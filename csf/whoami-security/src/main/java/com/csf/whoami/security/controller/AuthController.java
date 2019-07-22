/**
 * 
 */
package com.csf.whoami.security.controller;

import java.net.URI;

import javax.validation.Valid;

/**
 * @author mba0051
 *
 */
//import com.example.springsocial.exception.BadRequestException;
//import com.example.springsocial.model.AuthProvider;
//import com.example.springsocial.model.User;
//import com.example.springsocial.payload.ApiResponse;
//import com.example.springsocial.payload.AuthResponse;
//import com.example.springsocial.payload.LoginRequest;
//import com.example.springsocial.payload.SignUpRequest;
//import com.example.springsocial.repository.UserRepository;
//import com.example.springsocial.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.csf.whoami.security.entity.AppUser;
import com.csf.whoami.security.entity.AuthProvider;
import com.csf.whoami.security.exception.BadRequestException;
import com.csf.whoami.security.factory.TokenProvider;
import com.csf.whoami.security.payloads.ApiResponse;
import com.csf.whoami.security.payloads.AuthResponse;
import com.csf.whoami.security.payloads.LoginRequest;
import com.csf.whoami.security.payloads.SignUpRequest;
import com.csf.whoami.security.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private TokenProvider tokenProvider;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = tokenProvider.createToken(authentication);
		return ResponseEntity.ok(new AuthResponse(token));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			throw new BadRequestException("Email address already in use.");
		}

		// Creating user's account
		AppUser user = new AppUser();
		user.setName(signUpRequest.getName());
		user.setUserEmail(signUpRequest.getEmail());
		user.setUserPass(signUpRequest.getPassword());
		user.setProvider(AuthProvider.local);

		// TODO: Encrypt password - please re-check.
		user.setUserPass(passwordEncoder.encode(user.getUserPass()));

		AppUser result = userRepository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/me")
				.buildAndExpand(result.getId()).toUri();

		return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully@"));
	}

}