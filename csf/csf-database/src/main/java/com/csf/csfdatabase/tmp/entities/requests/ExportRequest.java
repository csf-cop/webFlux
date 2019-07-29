package com.csf.csfdatabase.tmp.entities.requests;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The request to export data.
 */
@Getter
@Setter
@ToString(callSuper = true)
public class ExportRequest {

  /**
   * The type.
   */
  @NotBlank
  private String type;
}
