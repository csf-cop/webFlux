/**
 * 
 */
package com.csf.whoami.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csf.whoami.adapter.GroupConvertAdapter;
import com.csf.whoami.domain.GroupDTO;
import com.csf.whoami.entity.GroupEntity;
import com.csf.whoami.repository.GroupRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

/**
 * @author mba0051
 *
 */
@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupRepository groupRepository;
	@Autowired
	private Scheduler scheduler;
	@Autowired
	GroupConvertAdapter groupAdapter;

	@Override
	public Flux<GroupDTO> findAll() {
		List<GroupEntity> entities = groupRepository.findAll();
		return Flux.defer(() -> Flux.fromIterable(entities.stream()
						.map(p -> new GroupDTO(p.getGroupId(), p.getGroupName()))
						.collect(Collectors.toList()))
				).subscribeOn(scheduler);
	}

	@Override
	public Flux<GroupDTO> findAllByUserId(String userId) {
		List<GroupEntity> entities = groupRepository.findByUserId();
		return Flux.defer(() -> Flux.fromIterable(entities.stream()
						.map(p -> new GroupDTO(p.getGroupId(), p.getGroupName()))
						.collect(Collectors.toList()))
				).subscribeOn(scheduler);
	}

	@Override
	public Mono<GroupDTO> findById(String groupId) {
		GroupEntity group = groupRepository.findById(groupId).orElse(new GroupEntity());
		return Mono.fromCallable(
				() -> groupAdapter.groupEntityToGroupDtoConvert(group)
				).publishOn(scheduler);
	}

}
