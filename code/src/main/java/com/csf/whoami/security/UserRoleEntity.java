/**
 * 
 */
package com.csf.whoami.security;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author TuanDQ
 *
 */
@Entity
@Table(name = "S03DT_USER_ROLE")
public class UserRoleEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "S03DT_USER_ROLE_SEQ", sequenceName = "S03DT_USER_ROLE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "S03DT_USER_ROLE_SEQ")
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(name = "FK_S01DT_USER1"))
	private UserEntity user;

	@ManyToOne(optional = false)
	@JoinColumn(name = "ROLE_ID", foreignKey = @ForeignKey(name = "FK_S02ST_ROLE1"))
	private RoleEntity role;

	@Column(name = "IS_DELETED", columnDefinition = "Numeric(2,0) default '0'")
	private Integer isDeleted;
}
