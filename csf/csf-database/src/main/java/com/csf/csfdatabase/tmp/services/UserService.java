package com.csf.csfdatabase.tmp.services;

import com.topcoder.idtool.entities.IdNameEntity;
import com.topcoder.idtool.entities.requests.GetLocationsRequest;
import com.topcoder.idtool.entities.responses.PagingResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The user service
 */
@Service
public class UserService extends BaseService{
  /**
   * get users
   * @return the users
   */
  public PagingResponse getUsers(){
    return executeSp("spGetUsers", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
        result->{
          return IdNameEntity.<String>builder()
              .id((String) result[0])//
              .name((String) result[1])
              .build();
        }, false);
  }
}
