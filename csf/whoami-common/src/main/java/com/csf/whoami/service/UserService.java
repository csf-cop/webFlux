/**
 * 
 */
package com.csf.whoami.service;

import com.csf.whoami.domain.UserDTO;

/**
 * @author tuan
 *
 */
public interface UserService {

	boolean existsByEmail(String email);

	UserDTO signUp(UserDTO user);

	UserDTO findById(String id);

	UserDTO findByUsername(String userName);

	UserDTO addUser(UserDTO user);

	UserDTO updateUser(UserDTO existingUser);
}
