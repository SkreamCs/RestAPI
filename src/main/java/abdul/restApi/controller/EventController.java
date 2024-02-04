package abdul.restApi.controller;

import abdul.restApi.model.Event;
import abdul.restApi.model.File;
import abdul.restApi.model.User;
import abdul.restApi.service.EventService;


import java.util.List;

public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    public Event createEvent(User user, File file) {
        return eventService.saveEvent(new Event(user, file));
    }
    public Event updateEvent(Event event) {
        return eventService.updateEvent(event);
    }
    public void deleteEvent(int id) {
        eventService.deleteEvent(id);
    }
    public Event getByIdEvent(int id) {
        return eventService.getByIdEvent(id);
    }
    public List<Event> getAllEvent() {
        return eventService.getAllEvent();
    }
}
