package com.csf.csfdatabase.tmp.entities;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The attendee entity.
 */
@Getter
@Setter
@ToString
@Builder
public class Attendee {

  /**
   * The sign in time.
   */
  private Date signInTime;

  /**
   * The attendee.
   */
  private String attendee;

  /**
   * The email.
   */
  private String email;

  /**
   * The supervisor.
   */
  private String supervisor;
}
