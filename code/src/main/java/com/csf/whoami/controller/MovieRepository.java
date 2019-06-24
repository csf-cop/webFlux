/**
 * 
 */
package com.csf.whoami.controller;

import reactor.core.publisher.Flux;

/**
 * @author TuanDQ
 *
 */
public interface MovieRepository {
	Flux<Movie> findAll();
}
