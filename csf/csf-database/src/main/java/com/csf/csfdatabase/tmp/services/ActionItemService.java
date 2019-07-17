package com.csf.csfdatabase.tmp.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.topcoder.idtool.entities.responses.PagingResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.topcoder.idtool.entities.ActionItem;
import com.topcoder.idtool.entities.IdNameEntity;
import com.topcoder.idtool.entities.requests.CreateActionItemRequest;
import com.topcoder.idtool.entities.requests.GetActionItemsRequest;
import com.topcoder.idtool.entities.requests.GetMyReportersRequest;
import com.topcoder.idtool.entities.requests.PagingRequest;
import com.topcoder.idtool.entities.requests.SortOrder;
import com.topcoder.idtool.entities.requests.UpdateActionItemRequest;

/**
 * The action item service.
 */
@Service
public class ActionItemService extends BaseService {

  /**
   * The list of properties that are allowed for sorting.
   */
  private static final List<String> ALLOWED_SORT_COLUMNS = Arrays.asList("status", "type", "title",
      "moc", "assignedBy", "assignedTo", "dueDate", "completedDate", "recommendation",
      "cause", "sssce", "pse", "plans", "concerns");

  /**
   * The list of action item types.
   */
  private static final List<String> ACTION_ITEM_TYPES =
      Arrays.asList("All", "PHA", "PSSR", "Cause Map", "CEM", "Incident Review", "PSM Audit", "General");

  /**
   * Get action items.
   * 
   * @param searchRequest the search request
   * @param pagingRequest the paging request
   * @return the action items
   */
  @SuppressWarnings("rawtypes")
  public PagingResponse getActionItems(GetActionItemsRequest searchRequest,
                                       PagingRequest pagingRequest) {
    validateSortColumn(ALLOWED_SORT_COLUMNS, pagingRequest.getSortBy());
    validateValueInList(ACTION_ITEM_TYPES, searchRequest.getType(), "type");

    List<String> parameterNames = new ArrayList<>();
    List<Class> parameterClasses = new ArrayList<>();
    List<Object> parameterValues = new ArrayList<>();

    parameterNames.add("StartDateTime");
    parameterClasses.add(Date.class);
    parameterValues.add(searchRequest.getStartDate());

    parameterNames.add("EndDateTime");
    parameterClasses.add(Date.class);
    parameterValues.add(searchRequest.getEndDate());

    parameterNames.add("KeywordsList");
    parameterClasses.add(String.class);
    parameterValues.add(searchRequest.getKeyword() == null ? ""
        : String.join("|", searchRequest.getKeyword()));

    parameterNames.add("Type");
    parameterClasses.add(Integer.class);
    parameterValues.add(ACTION_ITEM_TYPES.indexOf(searchRequest.getType()));

    parameterNames.add("Assignee");
    parameterClasses.add(String.class);
    parameterValues.add(searchRequest.getAssignee());

    parameterNames.add("Recommendation");
    parameterClasses.add(String.class);
    parameterValues.add(searchRequest.getRecommendation());

    parameterNames.add("Title");
    parameterClasses.add(String.class);
    parameterValues.add(searchRequest.getTitle());

    parameterNames.add("Cause");
    parameterClasses.add(String.class);
    parameterValues.add(searchRequest.getCause());

    parameterNames.add("SSSCE");
    parameterClasses.add(String.class);
    parameterValues.add(searchRequest.getSssce());

    parameterNames.add("PSE");
    parameterClasses.add(String.class);
    parameterValues.add(searchRequest.getPse());

    parameterNames.add("Plans");
    parameterClasses.add(String.class);
    parameterValues.add(searchRequest.getPlans());

    parameterNames.add("Concerns");
    parameterClasses.add(String.class);
    parameterValues.add(searchRequest.getConcerns());

    parameterNames.add("Status");
    parameterClasses.add(String.class);
    parameterValues.add(searchRequest.getStatus());

    parameterNames.add("pageIndex");
    parameterClasses.add(Integer.class);
    parameterValues.add(pagingRequest.getPageIndex());

    parameterNames.add("pageNo");
    parameterClasses.add(Integer.class);
    parameterValues.add(pagingRequest.getPageNo());

    parameterNames.add("sortOrder");
    parameterClasses.add(String.class);
    parameterValues.add(pagingRequest.getSortOrder() == null ? SortOrder.ASC.toString()
        : pagingRequest.getSortOrder().toString());

    parameterNames.add("sortBy");
    parameterClasses.add(String.class);
    parameterValues.add(pagingRequest.getSortBy());

    return executeSp("spGetActionItems", parameterNames, parameterClasses, parameterValues,
        result -> {
          int resultIndex = 0;
          ActionItem actionItem = ActionItem.builder() //
              .type((String) result[resultIndex++]) //
              .title((String) result[resultIndex++]) //
              .moc((String) result[resultIndex++]) //
              .assignedBy((String) result[resultIndex++]) //
              .assignedTo((String) result[resultIndex++]) //
              .dueDate((Date) result[resultIndex++]) //
              .completedDate((Date) result[resultIndex++]) //
              .recommendation((String) result[resultIndex++]) //
              .cause((String) result[resultIndex++]) //
              .sssce((String) result[resultIndex++]) //
              .pse((String) result[resultIndex++]) //
              .plans((String) result[resultIndex++]) //
              .concerns((String) result[resultIndex++]) //
              .status((String) result[resultIndex++]) //
              .id(((BigInteger) result[resultIndex++]).intValue()) //
              .completedBy((String) result[resultIndex++]) //
              .completedComment((String) result[resultIndex++]) //
              .assigneeEmail((String) result[resultIndex++]) //
              .completedByName((String) result[resultIndex++]) //
              .assignedDate((Date) result[resultIndex++]) //
              .build();
          return actionItem;
        }, true);
  }

  /**
   * Get the action item template list.
   * 
   * @return the action item template list
   */
  public PagingResponse getGeneralActionItemTemplate() {
    return executeSp("spGetGeneralActionItemTemplate", new ArrayList<>(), new ArrayList<>(),
        new ArrayList<>(), result -> {
          int resultIndex = 0;
          return IdNameEntity.<Integer>builder() //
              .id((Integer) result[resultIndex++]) //
              .name((String) result[resultIndex++]) //
              .build();
        }, false);
  }

  /**
   * Get the users who report to me directly and indirectly.
   *
   * @param request the request
   * @return the users
   */
  public PagingResponse getMyReporters(GetMyReportersRequest request) {
    return executeSp("spGetMyReporters", Arrays.asList("UserID"), Arrays.asList(String.class),
        Arrays.asList(request.getUserId()), result -> {
          return IdNameEntity.<String>builder() //
              .id((String) result[0]) //
              .name((String) result[1]) //
              .build();
        }, false);
  }

  /**
   * Create an action item.
   *
   * @param request the request
   */
  @Transactional(readOnly = false)
  public void createActionItem(CreateActionItemRequest request) {
    validateValueInList(ACTION_ITEM_TYPES.subList(1, ACTION_ITEM_TYPES.size()), request.getType(),
        "type");

    executeSp("spCreateActionItem", //
        Arrays.asList("ActionTitle", "ActionItemMod", "GeneralActionItem", "ActionItemMocNum",
            "ActionItemRecomm", "Assignees", "DueDate", "Cause", "SafeStart", "ProcessSafetyElement",
            "ActionItemCemAssociatedPlan", "ActionItemCemConcerns", "LogBy", "LogDate"),
        Arrays.asList(String.class, Integer.class, Integer.class, String.class, String.class,
            String.class, Date.class, String.class, String.class, String.class, String.class,
            String.class, String.class, Date.class),
        Arrays.asList(request.getTitle(), ACTION_ITEM_TYPES.indexOf(request.getType()),
            request.getGeneralActionItemId(), request.getMocNum(), request.getRecommendation(),
            String.join(";", request.getAssignees()), request.getDueDate(),
            request.getCause(), request.getSafeStart(), request.getProcessSafetyElement(),
            request.getCemAssociatedPlan(), request.getCemConcerns(), request.getLogBy(), request.getLogDate()),
        null, false);
  }

  /**
   * Update an action item.
   *
   * @param request the request
   */
  @Transactional(readOnly = false)
  public void updateActionItem(UpdateActionItemRequest request) {
    executeSp("spUpdateActionItem", //
        Arrays.asList("ActionItemID", "CompletedDate", "DueDate", "CompletedBy", "Status", "Comment"),
        Arrays.asList(Integer.class, Date.class, Date.class, String.class, String.class, String.class),
        Arrays.asList(request.getId(), request.getCompletedDate(), request.getDueDate(),
            String.join(";", request.getCompleter()), request.getStatus(), request.getComment()),
        null, false);
  }
}
