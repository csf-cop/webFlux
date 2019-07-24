/**
 * 
 */
package com.csf.whoami.adapter;

import org.springframework.stereotype.Component;

import com.csf.whoami.domain.UserDTO;
import com.csf.whoami.entity.RolesEntity;
import com.csf.whoami.entity.UserEntity;
import com.csf.whoami.entity.UserInfoEntity;
import com.whoami.common.utilities.AuthProvider;

/**
 * @author tuan
 *
 */
@Component
public class UserConvertAdapterImpl implements UserConvertAdapter {

	@Override
	public UserEntity userDtoToUserEntityConvert(UserDTO dto) {
		UserEntity entity = new UserEntity();
		entity.setUserId(dto.getUserId());
		entity.setUserName(dto.getUserName());
		entity.setUserPassword(dto.getPassword());
		// TODO : Review again.
		dto.getProvider();
		entity.setUserType(String.valueOf(AuthProvider.local));
		return entity;
	}

	@Override
	public UserInfoEntity userDtoToUserInfoEntityConvert(UserDTO dto) {
		UserInfoEntity entity = new UserInfoEntity();
		entity.setUserId(dto.getUserId());
		entity.setEmail(dto.getEmail());
		entity.setFullAddress(dto.getAddress());
		entity.setDateOfBirth(dto.getDateOfBirth());
		return entity;
	}

	@Override
	public RolesEntity userDtoToRolesEntityConvert(UserDTO dto) {
		RolesEntity entity = new RolesEntity();
		entity.setRoleName(dto.getUserRole());
		return entity;
	}

	@Override
	public void userEntityToUserDtoConvert(UserEntity entity, UserDTO userDto) {
		userDto.setUserId(entity.getUserId());
		userDto.setUserName(entity.getUserName());
		userDto.setProviderId(entity.getUserType());
	}

	@Override
	public void userInfoEntityToUserDtoConvert(UserInfoEntity entity, UserDTO dto) {
		dto.setAddress(entity.getFullAddress());
		dto.setDateOfBirth(entity.getDateOfBirth());
		dto.setEmail(entity.getEmail());
	}

	@Override
	public void rolesEntityToUserDtoConvert(RolesEntity entity, UserDTO dto) {
		dto.setUserRole(entity.getRoleName());
	}

}
