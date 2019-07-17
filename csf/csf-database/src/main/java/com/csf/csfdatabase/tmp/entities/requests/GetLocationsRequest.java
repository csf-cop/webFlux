package com.csf.csfdatabase.tmp.entities.requests;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * The request to get locations
 */
@Getter
@Setter
@ToString
public class GetLocationsRequest {
  /**
   * The group
   */
  @NotBlank
  private String group;
}
