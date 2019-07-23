/**
 * 
 */
package com.csf.whoami.entity;

import java.sql.Timestamp;

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
@Table(name = "H03DT_ROLES", uniqueConstraints = { @UniqueConstraint(columnNames = "user_id_card") })
public class RolesEntity {
	@Id
	private String id;

	@Column(name = "role_name")
	private String roleName;

	@Column(name = "role_note")
	private String roleNote;

	@Column(name = "create_date")
	private Timestamp createDate;

	@Column(name = "updated_date")
	private Timestamp updatedDate;

	@Column(name = "update_by")
	private String updateBy;

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
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the roleNote
	 */
	public String getRoleNote() {
		return roleNote;
	}

	/**
	 * @param roleNote the roleNote to set
	 */
	public void setRoleNote(String roleNote) {
		this.roleNote = roleNote;
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
	 * @return the updatedDate
	 */
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
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
}
