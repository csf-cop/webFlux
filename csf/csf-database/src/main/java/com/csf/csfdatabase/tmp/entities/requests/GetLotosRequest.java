package com.csf.csfdatabase.tmp.entities.requests;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * The request to get LOTO items.
 */
@Getter
@Setter
@ToString
public class GetLotosRequest extends CommonSearchRequest {

  /**
   * The type.
   */
  @NotBlank
  private String type;

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
   * The loto group
   */
  private String group;

  /**
   * The loto location
   */
  private String location;

  /**
   * The date
   */
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Date lotoDate;

  /**
   * The loto operator
   */
  private String lotoOperator;

  /**
   * The loto reason
   */
  private String lotoReason;

  /**
   * The removed date
   */
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Date lotoRemovedDate;

  /**
   * The 3rd party locks
   */
  private String partyLocks;

  /**
   *
   */
  private String processPoints;

  /**
   * The remover
   */
  private  String remover;
}
