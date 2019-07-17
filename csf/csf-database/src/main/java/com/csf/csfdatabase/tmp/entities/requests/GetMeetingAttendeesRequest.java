package com.csf.csfdatabase.tmp.entities.requests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The request to get meeting attendees.
 */
@Getter
@Setter
@ToString(callSuper = true)
public class GetMeetingAttendeesRequest {

  /**
   * The session id.
   */
  @NotNull
  @Min(1)
  private Integer sessionId;
}
