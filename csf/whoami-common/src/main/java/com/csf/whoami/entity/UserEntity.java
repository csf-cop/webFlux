/**
 * 
 */
package com.csf.whoami.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author tuan
 *
 */
@Entity
@Table(name = "H01DT_USERS", uniqueConstraints = { @UniqueConstraint(columnNames = "user_name") })
public class UserEntity {

	@Id
	private String id;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_password")
	private String userPassword;

	@Column(name = "user_info")
	private String userInfo;

	@Column(name = "user_type")
	private String userType;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * @return the userInfo
	 */
	public String getUserInfo() {
		return userInfo;
	}

	/**
	 * @param userInfo the userInfo to set
	 */
	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
}
