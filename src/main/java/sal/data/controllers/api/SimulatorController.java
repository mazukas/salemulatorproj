package sal.data.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sal.data.models.events.Event;
import sal.data.services.EventsServices;

@RestController
@RequestMapping(value={"/api/v1","/api/v2/aa"})
public class SimulatorController {

	@Autowired
	private EventsServices eventsServices;
	
	@RequestMapping(	value="/{appId:[A-Z][A-Z_0-9]{1,}}/{eventType:web|ping|searches|messages|permissions|items|sessions|accounts}", 
						method=RequestMethod.POST, 
						consumes=MediaType.APPLICATION_JSON_VALUE, 
						produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Event> event(	@PathVariable String appId, 
										@PathVariable String eventType, 
										@RequestBody String body) {
		Event event = new Event();
		event.setAppName(appId);
		event.setEventType(eventType);
		
		//validate and return body
		event.setRaw(body);
		eventsServices.saveEvent(event);
		
		return new ResponseEntity<Event>(event, HttpStatus.ACCEPTED);
	}
}
