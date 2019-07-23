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
@Table(name = "H05DT_GROUP")
public class UserGroupEntity {

	@Id
	private String id;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "group_id")
	private String groupId;

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
	 * @return the groupId
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
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
