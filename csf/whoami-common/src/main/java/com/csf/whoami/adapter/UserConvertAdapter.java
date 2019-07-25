/**
 * 
 */
package com.csf.whoami.adapter;

import com.csf.whoami.domain.UserDTO;
import com.csf.whoami.entity.RolesEntity;
import com.csf.whoami.entity.UserEntityHT;
import com.csf.whoami.entity.UserInfoEntity;

/**
 * @author tuan
 *
 */
public interface UserConvertAdapter {

	UserEntityHT userDtoToUserEntityConvert(UserDTO dto);

	void userEntityToUserDtoConvert(UserEntityHT entity, UserDTO userDto);

	UserInfoEntity userDtoToUserInfoEntityConvert(UserDTO dto);

	void userInfoEntityToUserDtoConvert(UserInfoEntity entity, UserDTO dto);

	RolesEntity userDtoToRolesEntityConvert(UserDTO dto);

	void rolesEntityToUserDtoConvert(RolesEntity entity, UserDTO dto);
}
