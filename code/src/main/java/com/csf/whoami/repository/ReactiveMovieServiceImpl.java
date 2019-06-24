/**
 * 
 */
package com.csf.whoami.repository;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csf.whoami.dto.Movie;

import reactor.core.publisher.Flux;

/**
 * @author TuanDQ
 *
 */
@Component
public class ReactiveMovieServiceImpl implements MovieService {

	@Autowired
	MovieRepository repo;

	@Override
	public Flux<Movie> getAllMovies() {
		List<Movie> allMovies = repo.findAll();
		return Flux.fromIterable(allMovies).delayElements(Duration.ofSeconds(2));
	}
}