/**
 * 
 */
package com.csf.whoami.service;

import java.util.Optional;

import com.csf.whoami.entity.UserEntity;

/**
 * @author mba0051
 *
 */
public interface UserService {

	Optional<UserEntity> findByEmail(String email);

	UserEntity save(UserEntity user);

	boolean existsByEmail(String email);

	Optional<UserEntity> findById(String id);

}
