package sal.data.models.events;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EventsRepository extends CrudRepository<Event, Long> {
	public List<Event> findByAppName(String appName);
	public List<Event> findByAppNameAndEventType(String appName, String eventType);
}