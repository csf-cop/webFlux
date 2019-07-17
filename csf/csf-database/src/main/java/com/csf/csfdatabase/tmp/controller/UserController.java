package com.csf.csfdatabase.tmp.controller;

import com.topcoder.idtool.entities.responses.PagingResponse;
import com.topcoder.idtool.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * the controller defines all user related endpoints
 */
@RestController
public class UserController {

  @Autowired
  private UserService service;

  /**
   * get users
   * @return the users
   */
  @GetMapping("/getUsers")
  public PagingResponse getUsers(){ return service.getUsers(); }
}
