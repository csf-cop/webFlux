/**
 * 
 */
package com.csf.whoami.service;

import com.csf.whoami.domain.GroupDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author mba0051
 *
 */
public interface GroupService {

	Flux<GroupDTO> findAll();
	Flux<GroupDTO> findAllByUserId(String userId);
	Mono<GroupDTO> findById(String groupId);
}
