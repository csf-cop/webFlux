/**
 * 
 */
package com.csf.whoami.service;

import java.util.List;

import com.csf.whoami.domain.GroupDomain;

/**
 * @author mba0051
 *
 */
public interface GroupService {

	List<GroupDomain> findAll();
}
