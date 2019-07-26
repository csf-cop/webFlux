/**
 * 
 */
package com.csf.whoami.service;

import java.util.Optional;

import com.csf.whoami.entity.UsersEntity;

/**
 * @author mba0051
 *
 */
public interface UserService {

	UsersEntity save(UsersEntity user);

	boolean existsByEmail(String email);

	Optional<UsersEntity> findById(String id);

	Optional<UsersEntity> findByUsername(String username);

}
