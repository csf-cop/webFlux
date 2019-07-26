/**
 * 
 */
package com.csf.whoami.adapter;

import org.springframework.stereotype.Component;

import com.csf.whoami.domain.GroupDomain;
import com.csf.whoami.entity.GroupEntity;

/**
 * @author mba0051
 *
 */
@Component
public class GroupConvertAdapterImpl implements GroupConvertAdapter {

	@Override
	public GroupDomain groupEntityToGroupDtoConvert(GroupEntity group) {
		GroupDomain dto = new GroupDomain();
		dto.setGroupId(group.getGroupId());
		dto.setGroupName(group.getGroupName());
		return dto;
	}

}
