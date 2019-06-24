/**
 * 
 */
package com.csf.whoami.router;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

/**
 * @author TuanDQ
 *
 */
@Component
public class WelcomeHandler {

	public Mono<ServerResponse> hello(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.TEXT_HTML).render("index");
	}

	public Mono<ServerResponse> welcome(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.TEXT_HTML).render("welcome");
	}
}
