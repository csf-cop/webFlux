/**
 * 
 */
package com.csf.whoami.adapter;

import com.csf.whoami.domain.UserDTO;
import com.csf.whoami.entity.UserEntity;
import com.csf.whoami.entity.UserInfoEntity;

/**
 * @author tuan
 *
 */
public interface UserConvertAdapter {

	public void userDtoToUserEntityConvert(UserDTO dto, UserEntity entity);

	public void userEntityToUserDtoConvert(UserEntity entity, UserDTO dto);

	public void userDtoToUserInfoEntityConvert(UserDTO dto, UserInfoEntity entity);

	public void userInfoEntityToUserDtoConvert(UserInfoEntity entity, UserDTO dto);
}
