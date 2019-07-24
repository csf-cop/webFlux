/**
 * 
 */
package com.csf.whoami.adapter;

import org.springframework.stereotype.Component;

import com.csf.whoami.domain.GroupDTO;
import com.csf.whoami.entity.GroupEntity;

/**
 * @author mba0051
 *
 */
@Component
public class GroupConvertAdapterImpl implements GroupConvertAdapter {

	@Override
	public GroupDTO groupEntityToGroupDtoConvert(GroupEntity group) {
		GroupDTO dto = new GroupDTO();
		dto.setGroupId(group.getGroupId());
		dto.setGroupName(group.getGroupName());
		return dto;
	}

}
