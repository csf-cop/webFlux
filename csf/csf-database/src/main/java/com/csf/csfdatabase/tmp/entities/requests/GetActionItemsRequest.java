package com.csf.csfdatabase.tmp.entities.requests;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The request to get action items.
 */
@Getter
@Setter
@ToString(callSuper = true)
public class GetActionItemsRequest extends CommonSearchRequest {

  /**
   * The type.
   */
  @NotBlank
  private String type;

  /**
   * The assignee.
   */
  private String assignee;

  /**
   * The action item/recommendation.
   */
  private String recommendation;

  /**
   * The action item title.
   */
  private String title;

  /**
   * The action item cause.
   */
  private String cause;

  /**
   * The safeStart / critical error
   */
  private String sssce;

  /**
   * The process safty element
   */
  private String pse;

  /**
   * The CEM associated plans
   */
  private String plans;

  /**
   * The CEM concerns
   */
  private String concerns;

  /**
   * The action item status
   */
  private String status;
}
