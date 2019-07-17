package com.csf.csfdatabase.tmp.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The entity with id and name.
 */
@Getter
@Setter
@ToString
@Builder
public class IdNameEntity<T> {

  /**
   * The id.
   */
  private T id;

  /**
   * The name.
   */
  private String name;
}
