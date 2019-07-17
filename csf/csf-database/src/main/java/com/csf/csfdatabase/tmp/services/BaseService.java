package com.csf.csfdatabase.tmp.services;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import com.topcoder.idtool.entities.responses.PagingResponse;

/**
 * The base service class.
 */
public abstract class BaseService {

  /**
   * The entity manager.
   */
  @PersistenceContext
  protected EntityManager entityManager;

  /**
   * Validate sort column.
   * 
   * @param sortColumn the sort column
   * @throws IllegalArgumentException if the sort column is invalid
   */
  protected static void validateSortColumn(List<String> allowedSortColumns, String sortColumn) {
    validateValueInList(allowedSortColumns, sortColumn, "sortBy");
  }

  /**
   * Validate value in list.
   * 
   * @param value the value
   * @param name the parameter name
   * @throws IllegalArgumentException if the value is invalid
   */
  protected static void validateValueInList(List<String> allowedValues, String value, String name) {
    if (!allowedValues.contains(value)) {
      throw new IllegalArgumentException(name + " must be in " + allowedValues);
    }
  }

  /**
   * Execute stored procedure and get the results.
   * 
   * @param spName the stored procedure name
   * @param parameterNames the parameter names
   * @param parameterClasses the parameter classes
   * @param parameterValues the parameter values
   * @param mapper the result mapper
   * @return the results
   */
  @SuppressWarnings({"unchecked", "rawtypes"})
  protected <T> PagingResponse executeSp(String spName, List<String> parameterNames,
      List<Class> parameterClasses, List<Object> parameterValues,
      Function<? super Object[], T> mapper, boolean paging) {
    StoredProcedureQuery query = entityManager.createStoredProcedureQuery(spName);

    int totalCount = 0;

    int parameterCount = parameterNames.size();

    for (int i = 0; i < parameterCount; i++) {
      query.registerStoredProcedureParameter(parameterNames.get(i), parameterClasses.get(i),
          ParameterMode.IN);
    }

    if(paging){
      query.registerStoredProcedureParameter("totalCount", Integer.class, ParameterMode.OUT);
    }

    for (int i = 0; i < parameterCount; i++) {
      query.setParameter(parameterNames.get(i), parameterValues.get(i));
    }

    // Have result set and mapper
    if (query.execute() && mapper != null) {
      List resultList = query.getResultList();
      List<Object[]> result = null;

      if (resultList.isEmpty() || resultList.get(0) instanceof Object[]) {
        // Several columns in the result
        result = (List<Object[]>) resultList;
      } else {
        // Only one column in the result
        result = ((List<Object>) resultList).stream().map(x -> {
          return new Object[] {x};
        }).collect(Collectors.toList());
      }

      if(paging){
        totalCount = (int)query.getOutputParameterValue("totalCount");
      }else{
        totalCount = result.size();
      }

      return new PagingResponse(totalCount, result.stream().map(mapper).collect(Collectors.toList()));
    }

    // No result set or mapper
    return null;
  }
}
