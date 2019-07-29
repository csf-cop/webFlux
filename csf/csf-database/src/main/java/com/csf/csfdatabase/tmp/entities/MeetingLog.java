package com.csf.csfdatabase.tmp.entities;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The meeting log entity.
 */
@Getter
@Setter
@ToString
@Builder
public class MeetingLog {

  /**
   * The session id.
   */
  private Integer sessionID;

  /**
   * The name.
   */
  private String name;

  /**
   * The leader.
   */
  private String leader;

  /**
   * The session start date.
   */
  private Date startDate;

  /**
   * The session start date.
   */
  private Date endDate;

  /**
   * The notes.
   */
  private String notes;

  /**
   * The number of attendees of this session.
   */
  private int attendeesNumber;
}
