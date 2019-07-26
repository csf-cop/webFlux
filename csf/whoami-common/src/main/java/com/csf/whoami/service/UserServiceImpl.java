/**
 * 
 */
package com.csf.whoami.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csf.whoami.entity.UsersEntity;
import com.csf.whoami.repository.UserRepository;

/**
 * @author mba0051
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private UserRepository userRepository;

	@Override
	public UsersEntity save(UsersEntity user) {
		return userRepository.save(user);
	}

	@Override
	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}

	@Override
	public Optional<UsersEntity> findById(String userId) {
		return userRepository.findById(userId);
	}

	@Override
	public Optional<UsersEntity> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
