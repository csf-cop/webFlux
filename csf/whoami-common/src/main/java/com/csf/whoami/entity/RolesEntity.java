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

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * @author tuan
 *
 */
@Entity
@Table(name = "H03DT_ROLES", uniqueConstraints = { @UniqueConstraint(columnNames = "role_name") })
@Where(clause = "delflg = 0")
@SQLDelete(sql = "UPDATE H03DT_ROLES SET delflg = 1 WHERE role_id = ?")
public class RolesEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "role_id")
	private String roleId;

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
