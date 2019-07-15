/**
 * 
 */
package com.csf.whoami.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.csf.whoami.dto.Movie;

/**
 * @author TuanDQ
 *
 */
@Component
public interface MovieRepository extends JpaRepository<Movie, Long> {
}