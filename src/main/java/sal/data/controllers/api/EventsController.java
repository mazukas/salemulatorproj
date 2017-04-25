package sal.data.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sal.data.models.events.Event;
import sal.data.services.EventsServices;

@RestController
@RequestMapping("/api")
public class EventsController {

	@Autowired
	private EventsServices eventsServices;
	
	@RequestMapping(	value="/events/{appName:[A-Z][A-Z_0-9]{1,}}", 
						method=RequestMethod.GET, 
						produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Event> getAll(@PathVariable String appName) {
		return eventsServices.getAllEvents(appName);
	}
	
	@RequestMapping(	value="/events/{appName:[A-Z][A-Z_0-9]{1,}}/{eventType:web|ping|searches|messages|permissions|items|sessions|accounts}", 
						method=RequestMethod.GET, 
						produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Event> getAllByeventType(	@PathVariable String appName, 
											@PathVariable String eventType) {
		return eventsServices.getAllEventsByEventType(appName, eventType);
	}
}
