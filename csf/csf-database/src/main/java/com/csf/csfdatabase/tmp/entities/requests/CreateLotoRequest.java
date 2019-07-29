package com.csf.csfdatabase.tmp.entities.requests;

import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The request to create LOTO item.
 */
@Getter
@Setter
@ToString
public class CreateLotoRequest {
  /**
   * The LOTO date.
   */
  @NotNull
  @DateTimeFormat(iso = ISO.DATE_TIME)
  private Date lotoDate;

  /**
   * The reason.
   */
  @NotBlank
  private String lotoReason;

  /**
   * The operator.
   */
  @NotBlank
  private String lotoOperator;

  /**
   * The value process points.
   */
  private String valueProcessPoints;

  /**
   * The 3rd party locks.
   */
  private String thirdPartyLocks;

  /**
   * The location id.
   */
  private String locationId;

  /**
   * The location source
   */
  private String locationSource;
}
