/**
 * 
 */
package com.csf.whoami.security;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author TuanDQ
 *
 */
@Entity
@Table(name = "S01DT_USER")
public class UserEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "USERS_SEQ", sequenceName = "USERS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "USERS_SEQ")
    private Long id;

    @Column(name = "LOGIN_ID", length = 10)
    private String loginId;

    @Column(name = "USER_PASSWORD", length = 100)
    private String password;

    @Column(name = "FULL_NAME", length = 30)
    private String fullName;

    @Column(name = "PHONE", length = 20)
    private String phone;

    @Column(name = "FULL_ADDRESS", length = 60)
    private String fullAddress;

    @Column(name = "EMAIL", length = 80)
    private String email;

    @Column(name = "IS_DELETED", columnDefinition = "Numeric(2,0) default '0'")
    private Integer isDeleted;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserRoleEntity> userRoles;
}
