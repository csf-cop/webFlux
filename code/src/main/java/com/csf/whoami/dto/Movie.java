/**
 * 
 */
package com.csf.whoami.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author TuanDQ
 *
 */
@Entity
@Table(name = "tbl_movies")
public class Movie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long movieId;

	@Column(name = "movie_name", length = 200)
	private String name;

	@Column(name = "score")
	private Integer score;

	/**
	 * @return the movieId
	 */
	public Long getMovieId() {
		return movieId;
	}

	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	/**
	 * 
	 */
	public Movie() {
		super();
	}

	/**
	 * @param name
	 * @param score
	 */
	public Movie(String name, Integer score) {
		super();
		this.name = name;
		this.score = score;
	}
}