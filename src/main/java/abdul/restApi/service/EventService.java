package abdul.restApi.service;

import abdul.restApi.model.Event;
import abdul.restApi.model.File;
import abdul.restApi.repository.EventRepository;
import abdul.restApi.repository.UserRepository;

import java.util.List;

public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }
    public Event updateEvent(Event event) {
        return eventRepository.update(event);
    }
    public void deleteEvent(int id) {
        eventRepository.delete(id);
    }
    public Event getByIdEvent(int id) {
        return eventRepository.getById(id);
    }
    public List<Event> getAllEvent() {
        return eventRepository.getAll();
    }
}
