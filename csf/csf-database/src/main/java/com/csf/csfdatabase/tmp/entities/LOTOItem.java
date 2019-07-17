package com.csf.csfdatabase.tmp.entities;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The LOTO item entity.
 */
@Getter
@Setter
@ToString
@Builder
public class LOTOItem {

  /**
   * The id.
   */
  private Integer id;

  /**
   * The name.
   */
  private String lotoName;

  /**
   * The group name.
   */
  private String groupName;

  /**
   * The location.
   */
  private String location;

  /**
   * The date.
   */
  private Date lotoDate;

  /**
   * The operator.
   */
  private String lotoOperator;

  /**
   * The reason.
   */
  private String lotoReason;

  /**
   * The value process points.
   */
  private String valueProcessPoints;

  /**
   * The 3rd party locks.
   */
  private String thirdPartyLocks;

  /**
   * The removed date.
   */
  private Date lotoRemovedDate;

  /**
   * The remover's name.
   */
  private String removedBy;

  /**
   * The operator email
   */
  private String operatorEmail;

  /**
   * The remover's id.
   */
  private String removedById;
}
