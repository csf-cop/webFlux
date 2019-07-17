package com.csf.csfdatabase.tmp.entities.requests;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The request to get my reporters.
 */
@Getter
@Setter
@ToString
public class GetMyReportersRequest {

  /**
   * The user id.
   */
  @NotBlank
  private String userId;
}
