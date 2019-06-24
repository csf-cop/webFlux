/**
 * 
 */
package com.csf.whoami.repository;

import com.csf.whoami.dto.Movie;

import reactor.core.publisher.Flux;

/**
 * @author TuanDQ
 *
 */
public interface MovieRepository {
	Flux<Movie> findAll();
}
