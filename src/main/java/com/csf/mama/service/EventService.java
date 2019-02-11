/**
 * 
 */
package com.csf.mama.service;

import java.util.List;

import com.csf.mama.entity.Event;

/**
 * @author TuanDQ
 *
 */
public interface EventService {
	public List<Event> getAllPublicEvents();
	public List<Event> getOwnerEvents(Long userId);
	public List<Event> getJoinedEvents(Long userId);
	
	public Event addEvent(Event event);
	public Event updateEventInfo(Event event);
	public Event disableEvent(Long eventId);
}
