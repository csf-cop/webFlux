/**
 * 
 */
package com.csf.whoami.entity;

import java.sql.Timestamp;

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
@Table(name = "H05DT_GROUP")
@Where(clause = "delflg = 0")
@SQLDelete(sql = "UPDATE H05DT_GROUP SET delflg = 1 WHERE group_id = ?")
public class GroupEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "group_id")
	private String groupId;

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
}
