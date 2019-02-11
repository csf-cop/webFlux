/**
 * 
 */
package com.csf.mama.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csf.mama.entity.Event;
import com.csf.mama.repository.EventRepository;

/**
 * @author TuanDQ
 *
 */
@Service(value = "eventService")
public class EventServiceImpl implements EventService{

	@Autowired
	EventRepository repository;
	
	@Override
	public List<Event> getAllPublicEvents() {
		return repository.getAllPublicEvents();
	}

	@Override
	public List<Event> getOwnerEvents(Long userId) {
		// TODO Auto-generated method stub
		return repository.getEventsByOwner(userId);
	}

	@Override
	public List<Event> getJoinedEvents(Long userId) {
		// TODO Auto-generated method stub
		return repository.getEventsHasJoined(userId);
	}

	@Override
	public Event addEvent(Event event) {
		// TODO Auto-generated method stub
		return repository.addEvent(event);
	}

	@Override
	public Event updateEventInfo(Event event) {
		// TODO Auto-generated method stub
		return repository.updateInfo(event);
	}

	@Override
	public Event disableEvent(Long eventId) {
		// TODO Auto-generated method stub
		return repository.disable(eventId);
	}

}
