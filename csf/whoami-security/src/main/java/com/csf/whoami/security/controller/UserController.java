/**
 * 
 */
package com.csf.whoami.security.controller;

/**
 * @author mba0051
 *
 */
//import com.example.springsocial.exception.ResourceNotFoundException;
//import com.example.springsocial.model.User;
//import com.example.springsocial.repository.UserRepository;
//import com.example.springsocial.security.CurrentUser;
//import com.example.springsocial.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csf.whoami.security.entity.AppUser;
import com.csf.whoami.security.exception.ResourceNotFoundException;
import com.csf.whoami.security.model.CurrentUser;
import com.csf.whoami.security.model.UserPrincipal;
import com.csf.whoami.security.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/user/me")
	@PreAuthorize("hasRole('USER')")
	public AppUser getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
		return userRepository.findById(userPrincipal.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
	}
}