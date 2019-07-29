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
 * The request to update LOTO item.
 */
@Getter
@Setter
@ToString
public class UpdateLotoRequest {

  /**
   * The id.
   */
  @NotNull
  @Min(1)
  private Integer id;

  /**
   * The LOTO removed date.
   */
  @NotNull
  @DateTimeFormat(iso = ISO.DATE_TIME)
  private Date lotoRemovedDate;

  /**
   * The LOTO removed by.
   */
  @NotBlank
  private String lotoRemovedBy;
}
