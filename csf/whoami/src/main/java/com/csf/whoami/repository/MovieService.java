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
public interface MovieService {
	Flux<Movie> getAllMovies();
}