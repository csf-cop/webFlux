package com.csf.csfdatabase.tmp.entities.requests;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The request to create action item.
 */
@Getter
@Setter
@ToString
public class CreateActionItemRequest {

  /**
   * The title.
   */
  @NotBlank
  private String title;

  /**
   * The type.
   */
  @NotBlank
  private String type;

  /**
   * The general action item id.
   */
  @Min(1)
  private Integer generalActionItemId;

  /**
   * The recommendation.
   */
  @NotBlank
  private String recommendation;

  /**
   * The safe start.
   */
  private String safeStart;

  /**
   * The due date.
   */
  @NotNull
  @DateTimeFormat(iso = ISO.DATE_TIME)
  private Date dueDate;

  /**
   * The cause.
   */
  private String cause;

  /**
   * The process safety element.
   */
  private String processSafetyElement;

  /**
   * The assignees.
   */
  @NotEmpty
  private List<String> assignees;

  /**
   * The MOC num.
   */
  private String mocNum;

  /**
   * The CEM associated plan.
   */
  private String cemAssociatedPlan;

  /**
   * The CEM concerns.
   */
  private String cemConcerns;

  /**
   * logged user
   */
  @NotBlank
  private String logBy;

  /**
   * logged date
   */
  @NotNull
  @DateTimeFormat(iso = ISO.DATE_TIME)
  private Date logDate;
}
