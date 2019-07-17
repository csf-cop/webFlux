package com.csf.csfdatabase.tmp.entities.requests;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The common search request.
 */
@Getter
@Setter
@ToString
public class CommonSearchRequest {
  /**
   * The minimum date limit for searching.
   */
  public static final Date MIN_DATE = new Date(-5364662400000L); // 1800-01-01

  /**
   * The maximum date limit for searching.
   */
  public static final Date MAX_DATE = new Date(32535129600000L); // 3000-12-31

  /**
   * The keyword filter.
   */
  private List<String> keyword;

  /**
   * The start date filter.
   */
  @DateTimeFormat(iso = ISO.DATE_TIME)
  private Date startDate = MIN_DATE;

  /**
   * The end date filter.
   */
  @DateTimeFormat(iso = ISO.DATE_TIME)
  private Date endDate = MAX_DATE;
}
