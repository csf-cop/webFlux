/**
 * 
 */
package com.csf.whoami.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

/**
 * @author tuan
 *
 */
@Entity
@Table(name = "S02ST_ROLE")
@Where(clause = "delflg = 0")
public class RolesEntity extends BaseEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "role_id")
	private String id;

	@Column(name = "role_name", nullable = false, length = 100)
	private String name;

	@Column(name = "role_code", nullable = false, length = 20)
	private String code;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "s04st_user_roles", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = {
			@JoinColumn(name = "user_id") })
	private Set<UsersEntity> users;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "s05st_role_authorities", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = {
			@JoinColumn(name = "authority_id") })
	private Set<AuthorityEntity> authorities;

	public RolesEntity() {
		// No-op
	}

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
	 * Getter for property 'name'.
	 *
	 * @return Value for property 'name'.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for property 'name'.
	 *
	 * @param name Value to set for property 'name'.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for property 'code'.
	 *
	 * @return Value for property 'code'.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Setter for property 'code'.
	 *
	 * @param code Value to set for property 'code'.
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets authorities.
	 *
	 * @return the authorities
	 */
	public Set<AuthorityEntity> getAuthorities() {
		return authorities;
	}

	/**
	 * Sets authorities.
	 *
	 * @param authorities the authorities
	 */
	public void setAuthorities(Set<AuthorityEntity> authorities) {
		this.authorities = authorities;
	}

	/**
	 * Gets users.
	 *
	 * @return the users
	 */
	public Set<UsersEntity> getUsers() {
		return users;
	}

	/**
	 * Sets users.
	 *
	 * @param users the users
	 */
	public void setUsers(Set<UsersEntity> users) {
		this.users = users;
	}
}
