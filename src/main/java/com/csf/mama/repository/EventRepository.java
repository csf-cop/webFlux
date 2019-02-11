/**
 * 
 */
package com.csf.mama.repository;

import java.util.List;

import com.csf.mama.entity.Event;

/**
 * @author TuanDQ
 *
 */
public interface EventRepository {

	public List<Event> getAllPublicEvents();

	public List<Event> getEventsByOwner(Long userId);

	public List<Event> getEventsHasJoined(Long userId);

	public Event addEvent(Event event);

	public Event updateInfo(Event event);

	public Event disable(Long eventId);

}
