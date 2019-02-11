/**
 * 
 */
package com.csf.mama.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.csf.mama.entity.Event;

/**
 * @author TuanDQ
 *
 */
@SuppressWarnings("deprecation")
@Service
public class EventRepositoryImpl extends BaseRepository<Event, String> implements EventRepository {

	@Override
	public List<Event> getAllPublicEvents() {
		StringBuffer sb = new StringBuffer("SELECT id, title, location  FROM tbl_events event");
		Boolean isCheck = false;
		@SuppressWarnings({ "rawtypes" })
		SQLQuery query;

		List<Event> events = new ArrayList<Event>();
		if (isCheck == true) {
			query = getSessionFactory().getCurrentSession().createSQLQuery(sb.toString());
			/*
			 * if(!ValidateData.checkEmpty(sortB)){ //14
			 * query.setParameter("sortB", "%" + sortB + "%"); }
			 */

			@SuppressWarnings("unchecked")
			List<Object[]> result = query.list();
			if (!(CollectionUtils.isEmpty(result))) {
				Event event = null;

				for (Object[] obj : result) {
					event = new Event();
					event.setEvent_id((Long) obj[0]);
					event.setTitle(obj[1] == null ? null : obj[1].toString().trim());
					event.setTitle(obj[2] == null ? null : obj[2].toString().trim());

					events.add(event);
				}
			}
		}

		return events;
	}

	@Override
	public List<Event> getEventsByOwner(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getEventsHasJoined(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event addEvent(Event event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event updateInfo(Event event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event disable(Long eventId) {
		// TODO Auto-generated method stub
		return null;
	}

}
