package sal.data.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sal.data.models.events.Event;
import sal.data.models.events.EventsRepository;

@Service
public class EventsServices {
	
	@Autowired
	private EventsRepository eventsRepo;
	
	public void saveEvent(Event event) {
		eventsRepo.save(event);
	}
	
	public List<Event> getAllEvents(String appName) {
		return eventsRepo.findByAppName(appName);
	}

	public List<Event> getAllEventsByEventType(String appName, String eventType) {
		return eventsRepo.findByAppNameAndEventType(appName, eventType);
	}
}
