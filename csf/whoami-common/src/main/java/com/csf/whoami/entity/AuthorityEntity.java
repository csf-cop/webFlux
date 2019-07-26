/**
 * 
 */
package com.csf.whoami.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

/**
 * @author mba0051
 *
 */
@Table(name = "S03ST_AUTHORITY")
@Where(clause = "delflg = 0")
@Entity
public class AuthorityEntity extends BaseEntity {
    private static final long serialVersionUID = 3182353535271044146L;
    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "S03ST_AUTHORITY_SEQ", sequenceName = "S03ST_AUTHORITY_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "S03ST_AUTHORITY_SEQ")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "CODE", nullable = false, length = 20)
    private String code;

    @ManyToMany
    @JoinTable(name = "s05st_role_authorities", joinColumns = { @JoinColumn(name = "authority_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") })
    private Set<RolesEntity> roles;

    /**
     * Instantiates a new Authority entity.
     */
    public AuthorityEntity() {
    }

    /**
     * Instantiates a new Authority entity.
     *
     * @param name the name
     * @param code the code
     */
    public AuthorityEntity(String name, String code) {
        this.name = name;
        this.code = code;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets roles.
     *
     * @return the roles
     */
    public Set<RolesEntity> getRoles() {
        return roles;
    }

    /**
     * Sets roles.
     *
     * @param roles the roles
     */
    public void setRoles(Set<RolesEntity> roles) {
        this.roles = roles;
    }
}