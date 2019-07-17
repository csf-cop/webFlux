package com.csf.csfdatabase.tmp.entities.responses;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Common paging response
 */
@Getter
@Setter
@ToString
public class PagingResponse {
  public PagingResponse(int total, List rows){
    this.total = total;
    this.rows = rows;
  }

  /**
   * total records
   */
  private int total;

  /**
   * record list
   */
  private List rows;
}
