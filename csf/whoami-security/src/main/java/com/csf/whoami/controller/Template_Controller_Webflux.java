/**
 * 
 */
package com.csf.whoami.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.csf.whoami.domain.GroupDTO;
import com.csf.whoami.service.GroupService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

/**
 * @author mba0051
 *
 */
@Slf4j
@RestController
@RequestMapping("/group")
public class Template_Controller_Webflux {
//	@PostMapping("/memos")
//	public Mono<MemoResponseDTO> save(@Valid @RequestBody MemoRequestDTO memoRequestDTO) {
//		log.info("===== MemoController 시작 =====");
//		return memoService.save(memoRequestDTO).map(MemoResponseDTO::of).log();
//	}

	@Autowired
	private GroupService groupService;
	@Autowired
	private Scheduler scheduler;
	
	@GetMapping("/{id}")
	public Mono<ServerResponse> list(ServerRequest request) {
        Flux<GroupDTO> groups = Flux.defer(() -> Flux.fromIterable(groupService.findAll())).subscribeOn(scheduler);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(groups, GroupDTO.class);
    }

//	public Mono<ServerResponse> show(ServerRequest request) {
//        Long personId = Long.valueOf(request.pathVariable("id"));
//        return Mono.fromCallable(() -> this.personRepository.findById(personId).orElse(new Person()))
//            .publishOn(scheduler)
//            .flatMap(person -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(person)))
//            .switchIfEmpty(ServerResponse.notFound().build());
//    }
//
//    public Mono<ServerResponse> save(ServerRequest request) {
//        return request
//            .bodyToMono(Person.class)
//            .flatMap(person -> Mono.fromCallable(() -> this.personRepository.save(person)))
//            .publishOn(scheduler)
//            .flatMap(person -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(person)));
//    }
}