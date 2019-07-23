/**
 * 
 */
package com.csf.whoami.entity;

import java.sql.Timestamp;

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
public class GroupEntity {

	@Id
	private String id;

	@Column(name = "group_name")
	private String groupName;

	@Column(name = "group_owner")
	private String groupOwner;

	@Column(name = "create_date")
	private Timestamp createDate;

	@Column(name = "last_update")
	private Timestamp lastUpdate;

	@Column(name = "update_by")
	private String updateBy;

	@Column(name = "parent_group")
	private String parentGroup;

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
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return the groupOwner
	 */
	public String getGroupOwner() {
		return groupOwner;
	}

	/**
	 * @param groupOwner the groupOwner to set
	 */
	public void setGroupOwner(String groupOwner) {
		this.groupOwner = groupOwner;
	}

	/**
	 * @return the createDate
	 */
	public Timestamp getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the lastUpdate
	 */
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	/**
	 * @param lastUpdate the lastUpdate to set
	 */
	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	/**
	 * @return the updateBy
	 */
	public String getUpdateBy() {
		return updateBy;
	}

	/**
	 * @param updateBy the updateBy to set
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * @return the parentGroup
	 */
	public String getParentGroup() {
		return parentGroup;
	}

	/**
	 * @param parentGroup the parentGroup to set
	 */
	public void setParentGroup(String parentGroup) {
		this.parentGroup = parentGroup;
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
