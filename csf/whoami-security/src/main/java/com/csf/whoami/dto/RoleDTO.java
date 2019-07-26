package com.csf.whoami.dto;

import java.util.Set;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RoleDTO {
    private String id;
    private String code;
    private String name;
    private Set<AuthorityDTO> authorities;

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public String getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(String id) {
        this.id = id;
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
     * Gets authorities.
     *
     * @return the authorities
     */
    public Set<AuthorityDTO> getAuthorities() {
        return authorities;
    }

    /**
     * Sets authorities.
     *
     * @param authorities the authorities
     */
    public void setAuthorities(Set<AuthorityDTO> authorities) {
        this.authorities = authorities;
    }

    /**
     * Instantiates a new Role dto.
     *
     * @param id          the id
     * @param code        the code
     * @param name        the name
     * @param authorities the authorities
     */
    public RoleDTO(String id, String code, String name, Set<AuthorityDTO> authorities) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.authorities = authorities;
    }
}
