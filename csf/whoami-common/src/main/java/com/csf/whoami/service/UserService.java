/**
 * 
 */
package com.csf.whoami.service;

import java.util.Optional;

import com.csf.whoami.domain.UserDTO;

/**
 * @author tuan
 *
 */
public interface UserService {

	boolean existsByEmail(String email);

	UserDTO signUp(UserDTO user);

	Optional<UserDTO> findById(String id);

	Optional<UserDTO> findByUsername(String userName);

	UserDTO addUser(UserDTO user);

	UserDTO updateUser(UserDTO existingUser);
}
