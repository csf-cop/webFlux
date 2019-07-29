package com.csf.csfdatabase.tmp.entities.requests;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The request to update action item.
 */
@Getter
@Setter
@ToString
public class UpdateActionItemRequest {

  /**
   * The id.
   */
  @NotNull
  @Min(1)
  private Integer id;

  /**
   * The completed date.
   */
  @DateTimeFormat(iso = ISO.DATE_TIME)
  private Date completedDate;

  /**
   * The due date.
   */
  @NotNull
  @DateTimeFormat(iso = ISO.DATE_TIME)
  private Date dueDate;

  /**
   * The completer.
   */
  @NotEmpty
  private List<String> completer;

  /**
   * The rejected/completed status.
   */
  private String status;

  /**
   * The comment
   */
  private String comment;
}
