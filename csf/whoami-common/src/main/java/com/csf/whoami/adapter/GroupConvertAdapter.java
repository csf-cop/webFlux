/**
 * 
 */
package com.csf.whoami.adapter;

import com.csf.whoami.domain.GroupDTO;
import com.csf.whoami.entity.GroupEntity;

/**
 * @author mba0051
 *
 */
public interface GroupConvertAdapter {
	GroupDTO groupEntityToGroupDtoConvert(GroupEntity group);
}
