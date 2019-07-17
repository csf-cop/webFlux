package com.csf.csfdatabase.tmp.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.topcoder.idtool.entities.requests.GetLocationsRequest;
import com.topcoder.idtool.entities.responses.PagingResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.topcoder.idtool.entities.IdNameEntity;
import com.topcoder.idtool.entities.LOTOItem;
import com.topcoder.idtool.entities.requests.CreateLotoRequest;
import com.topcoder.idtool.entities.requests.GetLotosRequest;
import com.topcoder.idtool.entities.requests.UpdateLotoRequest;

/**
 * The LOTO service.
 */
@Service
public class LotoService extends BaseService {

  /**
   * The list of LOTO item types.
   */
  private static final List<String> LOTO_ITEM_TYPES = Arrays.asList("All", "Current", "Historical");

  /**
   * Get LOTO items.
   * 
   * @param request the request
   * @return the LOTO items
   */
  public PagingResponse getLotos(GetLotosRequest request) {
    validateValueInList(LOTO_ITEM_TYPES, request.getType(), "type");

    return executeSp("spGetLotos", //
        Arrays.asList("StartDateTime", "EndDateTime", "KeywordsList", "Type", "pageIndex",
            "pageNo", "Group", "Location", "LotoDate", "LotoOperator", "LotoReason", "LotoRemovedDate",
            "PartyLocks", "ProcessPoints", "Remover"),
        Arrays.asList(Date.class, Date.class, String.class, String.class, Integer.class,
            Integer.class, String.class, String.class, Date.class, String.class, String.class,
            Date.class, String.class, String.class, String.class),
        Arrays.asList(request.getStartDate(), request.getEndDate(),
            request.getKeyword() == null ? ""
                : String.join("|", request.getKeyword()), request.getType(), request.getPageIndex(),
            request.getPageNo(), request.getGroup(), request.getLocation(), request.getLotoDate(), request.getLotoOperator(),
            request.getLotoReason(), request.getLotoRemovedDate(), request.getPartyLocks(), request.getProcessPoints(),request.getRemover()),
        result -> {
          int resultIndex = 0;
          return LOTOItem.builder() //
              .id((Integer) result[resultIndex++]) //
              .lotoName((String) result[resultIndex++]) //
              .groupName((String) result[resultIndex++]) //
              .location((String) result[resultIndex++]) //
              .lotoDate((Date) result[resultIndex++]) //
              .lotoOperator((String) result[resultIndex++]) //
              .lotoReason((String) result[resultIndex++]) //
              .valueProcessPoints((String) result[resultIndex++]) //
              .thirdPartyLocks((String) result[resultIndex++]) //
              .lotoRemovedDate((Date) result[resultIndex++]) //
              .removedBy((String) result[resultIndex++]) //
              .operatorEmail((String) result[resultIndex++]) //
              .removedById((String) result[resultIndex++]) //
              .build();
        }, true);
  }

  /**
   * Get group lists.
   * 
   * @return the group lists
   */
  public PagingResponse getGroupLists() {
    return executeSp("spGetGroupLists", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
        result -> {
          return IdNameEntity.<Integer>builder() //
              .id(((BigInteger) result[0]).intValue())
              .name((String) result[1]) //
              .build();
        }, false);
  }

  /**
   * Get LOTO operators.
   * 
   * @return the LOTO operators
   */
  public PagingResponse getLoToOperators() {
    return executeSp("spGetLoToOperators", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
        result -> {
          return IdNameEntity.<String>builder() //
              .id((String) result[0]) //
              .name((String) result[1]) //
              .build();
        }, false);
  }

  /**
   * Get LOTO locations
   * @param request the request
   * @return the locations
   */
  public PagingResponse getLocations(GetLocationsRequest request){
    return executeSp("spGetLocations", Arrays.asList("Group"), Arrays.asList(String.class), Arrays.asList(request.getGroup()),
        result->{
          return IdNameEntity.<String>builder()
              .id((String) result[0])//
              .name((String) result[1])
              .build();
        }, false);
  }

  /**
   * Create LOTO.
   * 
   * @param request the request
   */
  @Transactional(readOnly = false)
  public void createLoto(CreateLotoRequest request) {
    executeSp("spCreateLoTo", //
        Arrays.asList("LotoDate", "LotoReason", "LotoOperator",
            "ValueProcessPoints", "ThirdPartyLocks", "LocationId", "LocationSource"), //
        Arrays.asList(Date.class, String.class,
            String.class, String.class, String.class, String.class, String.class), //
        Arrays.asList(request.getLotoDate(), request.getLotoReason(), request.getLotoOperator(),
            request.getValueProcessPoints(), request.getThirdPartyLocks(), request.getLocationId(), request.getLocationSource()), //
        null, false);
  }

  /**
   * Upate a LOTO removed date.
   * 
   * @param request the request
   */
  public void updateLoto(UpdateLotoRequest request) {
    executeSp("spUpdateLoTo", //
        Arrays.asList("RecordID", "LotoRemovedDate", "LotoRemovedBy"), //
        Arrays.asList(Integer.class, Date.class, String.class), //
        Arrays.asList(request.getId(), request.getLotoRemovedDate(), request.getLotoRemovedBy()), //
        null, false);
  }
}
