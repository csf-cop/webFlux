/**
 * 
 */
package com.csf.whoami.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csf.whoami.adapter.UserConvertAdapter;
import com.csf.whoami.domain.UserDTO;
import com.csf.whoami.entity.RolesEntity;
import com.csf.whoami.entity.UserEntity;
import com.csf.whoami.entity.UserInfoEntity;
import com.csf.whoami.repository.RolesRepository;
import com.csf.whoami.repository.UserInfoRepository;
import com.csf.whoami.repository.UserRepository;

/**
 * @author tuan
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserInfoRepository infoRepository;
	@Autowired
	RolesRepository rolesRepository;

	@Autowired
	UserConvertAdapter convertAdapter;
	
	@Override
	public boolean existsByEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	@Override
	public UserDTO signUp(UserDTO user) {
		// Add new User.
		UserEntity userEntity = convertAdapter.userDtoToUserEntityConvert(user);
		UserEntity result = userRepository.save(userEntity);
		if (result != null) {
			convertAdapter.userEntityToUserDtoConvert(result, user);
		}

		UserInfoEntity info = convertAdapter.userDtoToUserInfoEntityConvert(user);
		UserInfoEntity resultInfo = infoRepository.save(info);
		if (resultInfo != null) {
			convertAdapter.userInfoEntityToUserDtoConvert(resultInfo, user);
		}

		RolesEntity role = convertAdapter.userDtoToRolesEntityConvert(user);
		RolesEntity roleResult = rolesRepository.save(role);
		if (roleResult != null) {
			convertAdapter.rolesEntityToUserDtoConvert(roleResult, user);
		}

		return user;
	}

	@Override
	public Optional<UserDTO> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<UserDTO> findByUsername(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO addUser(UserDTO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO updateUser(UserDTO existingUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
