package com.csf.csfdatabase.tmp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.csf.csfdatabase.tmp.entities.requests.CreateActionItemRequest;
import com.csf.csfdatabase.tmp.entities.requests.GetActionItemsRequest;
import com.csf.csfdatabase.tmp.entities.requests.GetMyReportersRequest;
import com.csf.csfdatabase.tmp.entities.requests.PagingRequest;
import com.csf.csfdatabase.tmp.entities.requests.UpdateActionItemRequest;
import com.csf.csfdatabase.tmp.entities.responses.PagingResponse;
import com.csf.csfdatabase.tmp.services.ActionItemService;

/**
 * The controller defines all action item end-points.
 */
@RestController
public class ActionItemController {

  /**
   * The service.
   */
  @Autowired
  private ActionItemService service;

  /**
   * Get action items.
   * 
   * @param searchRequest the search request
   * @param pagingRequest the paging request
   * @return the action items
   */
  @GetMapping("/getActionItems")
  public PagingResponse getActionItems(@Valid @ModelAttribute GetActionItemsRequest searchRequest,
                                       @Valid @ModelAttribute PagingRequest pagingRequest) {
    return service.getActionItems(searchRequest, pagingRequest);
  }

  /**
   * Get the action item template list.
   * 
   * @return the action item template list
   */
  @GetMapping("/getGeneralActionItemTemplate")
  public PagingResponse getGeneralActionItemTemplate() {
    return service.getGeneralActionItemTemplate();
  }

  /**
   * Get the users who report to me directly and indirectly.
   *
   * @param request the request
   * @return the users
   */
  @GetMapping("/getMyReporters")
  public PagingResponse getMyReporters(
      @Valid @ModelAttribute GetMyReportersRequest request) {
    return service.getMyReporters(request);
  }

  /**
   * Create an action item.
   *
   * @param request the request
   */
  @PostMapping("/createActionItem")
  public void createActionItem(@Valid @RequestBody CreateActionItemRequest request) {
    service.createActionItem(request);
  }

  /**
   * Update an action item.
   *
   * @param request the request
   */
  @PostMapping("/updateActionItem")
  public void updateActionItem(@Valid @RequestBody UpdateActionItemRequest request) {
    service.updateActionItem(request);
  }
}
