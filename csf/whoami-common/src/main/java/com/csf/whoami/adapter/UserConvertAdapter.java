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

	public UserEntity userDtoToUserEntityConvert(UserDTO dto);
	public void userEntityToUserDtoConvert(UserEntity entity, UserDTO userDto);

	public UserInfoEntity userDtoToUserInfoEntityConvert(UserDTO dto);
	public void userInfoEntityToUserDtoConvert(UserInfoEntity entity, UserDTO dto);
	
	public RolesEntity userDtoToRolesEntityConvert(UserDTO dto);
	public void rolesEntityToUserDtoConvert(RolesEntity entity, UserDTO dto);
}
