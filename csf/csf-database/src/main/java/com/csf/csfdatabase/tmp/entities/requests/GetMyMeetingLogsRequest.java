package com.csf.csfdatabase.tmp.entities.requests;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The request to get my meeting logs.
 */
@Getter
@Setter
@ToString(callSuper = true)
public class GetMyMeetingLogsRequest extends CommonSearchRequest {

  /**
   * The user id.
   */
  @NotBlank
  private String userId;
}
