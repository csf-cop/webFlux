/**
 * 
 */
package com.csf.whoami.service;

import java.util.List;

import com.csf.whoami.domain.GroupDTO;

/**
 * @author mba0051
 *
 */
public interface GroupService {

	List<GroupDTO> findAll();
}
