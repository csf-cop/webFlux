/**
 * 
 */
package com.csf.whoami.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * @author tuan
 *
 */
@Entity
@Table(name = "H04DT_USER_ROLE")
@Where(clause = "delflg = 0")
@SQLDelete(sql = "UPDATE H04DT_USER_ROLE SET delflg = 1 WHERE user_id = ?")
public class UserRoleEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_role_id")
	private String userRoleId;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "role_id")
	private String roleId;

	/**
	 * @return the userRoleId
	 */
	public String getUserRoleId() {
		return userRoleId;
	}

	/**
	 * @param userRoleId the userRoleId to set
	 */
	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the roleId
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
