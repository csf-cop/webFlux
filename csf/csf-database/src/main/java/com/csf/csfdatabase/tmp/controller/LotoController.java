package com.csf.csfdatabase.tmp.controller;

import java.util.List;
import javax.validation.Valid;

import com.topcoder.idtool.entities.requests.GetLocationsRequest;
import com.topcoder.idtool.entities.responses.PagingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.topcoder.idtool.entities.IdNameEntity;
import com.topcoder.idtool.entities.LOTOItem;
import com.topcoder.idtool.entities.requests.CreateLotoRequest;
import com.topcoder.idtool.entities.requests.GetLotosRequest;
import com.topcoder.idtool.entities.requests.UpdateLotoRequest;
import com.topcoder.idtool.services.LotoService;

/**
 * The controller defines all LOTO end-points.
 */
@RestController
public class LotoController {

  /**
   * The service.
   */
  @Autowired
  private LotoService service;

  /**
   * Get LOTO items.
   * 
   * @param request the request
   * @return the LOTO items
   */
  @GetMapping("/getLotos")
  public PagingResponse getLotos(@Valid @ModelAttribute GetLotosRequest request) {
    return service.getLotos(request);
  }

  /**
   * Get group lists.
   * 
   * @return the group lists
   */
  @GetMapping("/getGroupLists")
  public PagingResponse getGroupLists() {
    return service.getGroupLists();
  }

  /**
   * Get LOTO operators.
   * 
   * @return the LOTO operators
   */
  @GetMapping("/getLoToOperators")
  public PagingResponse getLoToOperators() {
    return service.getLoToOperators();
  }

  /**
   * Create LOTO.
   * 
   * @param request the request
   */
  @PostMapping("/upsertLoTo")
  public void createLoto(@Valid @RequestBody CreateLotoRequest request) {
    service.createLoto(request);
  }

  /**
   * Upate a LOTO removed date.
   * 
   * @param request the request
   */
  @PutMapping("/upsertLoTo")
  public void updateLoto(@Valid @RequestBody UpdateLotoRequest request) {
    service.updateLoto(request);
  }

  @GetMapping("/getLocations")
  public PagingResponse getLocations(@Valid @ModelAttribute GetLocationsRequest request){ return service.getLocations(request);}
}
