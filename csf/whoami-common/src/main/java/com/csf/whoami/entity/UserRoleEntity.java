/**
 * 
 */
package com.csf.whoami.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author tuan
 *
 */
@Entity
@Table(name = "H04DT_USER_ROLE")
public class UserRoleEntity {

	@Id
	private String id;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "role_id")
	private String roleId;

	@Column(name = "is_deleted")
	private Boolean isDeleted;

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

	/**
	 * @return the isDeleted
	 */
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}
