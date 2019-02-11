/**
 * 
 */
package com.csf.mama.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author TuanDQ
 *
 */
@Entity
@Table(name = "demo_event")
public class Event implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long event_id;

    @Column(name = "title")
    private String title;

    @Column(name = "location")
    private String location;

    @Column(name = "event_content")
    private String event_content;

    /**
     * @return the event_id
     */
    public Long getEvent_id() {
        return event_id;
    }

    /**
     * @param event_id the event_id to set
     */
    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the event_content
     */
    public String getEvent_content() {
        return event_content;
    }

    /**
     * @param event_content the event_content to set
     */
    public void setEvent_content(String event_content) {
        this.event_content = event_content;
    }

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
