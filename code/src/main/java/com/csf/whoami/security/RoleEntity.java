/**
 * 
 */
package com.csf.whoami.security;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author TuanDQ
 *
 */
@Entity
@Table(name = "TBL_ROLES")
public class RoleEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "S02ST_ROLE_SEQ", sequenceName = "S02ST_ROLE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "S02ST_ROLE_SEQ")
	private Long id;

	@Column(name = "ROLE_NAME", nullable = false, length = 100)
	private String name;

	@Column(name = "ROLE_CODE", nullable = false, length = 20)
	private String code;

	@Column(name = "IS_DELETED", columnDefinition = "Numeric(2,0) default '0'")
	private Integer isDeleted;
}
