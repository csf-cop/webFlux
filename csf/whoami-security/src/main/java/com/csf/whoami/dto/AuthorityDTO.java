package com.csf.whoami.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AuthorityDTO {
    private Long id;
    private String name;
    private String code;

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
     * Instantiates a new Authority dto.
     */
    public AuthorityDTO() {
    }

    /**
     * Instantiates a new Authority dto.
     *
     * @param id   the id
     * @param name the name
     * @param code the code
     */
    public AuthorityDTO(Long id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }
}
