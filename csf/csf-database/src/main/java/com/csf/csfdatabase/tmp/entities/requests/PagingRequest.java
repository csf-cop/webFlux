package com.csf.csfdatabase.tmp.entities.requests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The paging request.
 */
@Getter
@Setter
@ToString(callSuper = true)
public class PagingRequest {

  /**
   * The page index.
   */
  @NotNull
  @Min(1)
  private Integer pageIndex;

  /**
   * The records contained in one page.
   */
  @NotNull
  @Min(1)
  private Integer pageNo;

  /**
   * The sort by.
   */
  @NotBlank
  private String sortBy;

  /**
   * The sort order.
   */
  private SortOrder sortOrder;
}
