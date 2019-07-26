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
@Table(name = "H06DT_USER_GROUP")
@Where(clause = "delflg = 0")
@SQLDelete(sql = "UPDATE H06DT_USER_GROUP SET delflg = 1 WHERE user_id = ?")
public class UserGroupEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_group_id")
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
}
