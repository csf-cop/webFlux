/**
 * 
 */
package com.csf.whoami.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csf.whoami.adapter.GroupConvertAdapter;
import com.csf.whoami.domain.GroupDomain;
import com.csf.whoami.entity.GroupEntity;
import com.csf.whoami.repository.GroupRepository;

/**
 * @author mba0051
 *
 */
@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupRepository groupRepository;
	@Autowired
	private GroupConvertAdapter groupAdapter;

	@Override
	public List<GroupDomain> findAll() {
		List<GroupEntity> entities = groupRepository.findAll();

		List<GroupDomain> groups = new ArrayList<GroupDomain>();
		for (GroupEntity item : entities) {
			groups.add(groupAdapter.groupEntityToGroupDtoConvert(item));
		}

		return groups;
	}

}
