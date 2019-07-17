package com.csf.csfdatabase.tmp.entities;

import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The action item entity.
 */
@Getter
@Setter
@ToString
@Builder
public class ActionItem {

  /**
   * The type.
   */
  @NotBlank
  private String type;

  /**
   * The title.
   */
  @NotBlank
  private String title;

  /**
   * The moc.
   */
  @NotBlank
  private String moc;

  /**
   * The assigned by.
   */
  @NotBlank
  private String assignedBy;

  /**
   * The assigned to.
   */
  @NotBlank
  private String assignedTo;

  /**
   * The due date.
   */
  @NotNull
  @DateTimeFormat(iso = ISO.DATE_TIME)
  private Date dueDate;

  /**
   * The completed date.
   */
  @NotNull
  @DateTimeFormat(iso = ISO.DATE_TIME)
  private Date completedDate;

  /**
   * The action item recommendation
   */
  private String recommendation;

  /**
   * The action item cause
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
   * The completer ids
   */
  private String completedBy;

  /**
   * The comment of completer
   */
  private String completedComment;

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

  /**
   * The action item id
   */
  @Min(1)
  private Integer id;

  /**
   * email of assignees
   */
  private String assigneeEmail;

  /**
   * The completer names
   */
  private String completedByName;

  /**
   * The completed date.
   */
  @DateTimeFormat(iso = ISO.DATE_TIME)
  private Date assignedDate;
}
