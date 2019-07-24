/**
 * 
 */
package com.csf.whoami.adapter;

import com.csf.whoami.domain.UserDTO;
import com.csf.whoami.entity.RolesEntity;
import com.csf.whoami.entity.UserEntity;
import com.csf.whoami.entity.UserInfoEntity;

/**
 * @author tuan
 *
 */
public interface UserConvertAdapter {

	UserEntity userDtoToUserEntityConvert(UserDTO dto);

	void userEntityToUserDtoConvert(UserEntity entity, UserDTO userDto);

	UserInfoEntity userDtoToUserInfoEntityConvert(UserDTO dto);

	void userInfoEntityToUserDtoConvert(UserInfoEntity entity, UserDTO dto);

	RolesEntity userDtoToRolesEntityConvert(UserDTO dto);

	void rolesEntityToUserDtoConvert(RolesEntity entity, UserDTO dto);
}
