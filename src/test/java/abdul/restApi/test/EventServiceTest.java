package abdul.restApi.test;


import abdul.restApi.model.Event;
import abdul.restApi.model.File;
import abdul.restApi.model.User;
import abdul.restApi.repository.EventRepository;
import abdul.restApi.service.EventService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EventServiceTest {
    @Mock
    EventRepository eventRepository;
    @InjectMocks
    EventService eventService;

    @Test
    public void createEvent() {
        User user = new User("Varchar", new ArrayList<>());
        user.setId(1);
        File file = new File("swagger.json","C:/user/RestAPI/src/main/resources/storage/" );
        file.setId(1);
        Event event = new Event(user,file );

        Event expected = new Event(user, file);
        expected.setId(1);

        when(eventRepository.save(event)).thenReturn(expected);

        Event actual = eventService.saveEvent(event);

        assertEquals(expected, actual);
    }

    @Test
    public void updateEvent() {
        User user = new User("Abdul", new ArrayList<>());
        user.setId(1);
        File file = new File("postman.json","C:/user/RestAPI/src/main/resources/storage/" );
        file.setId(1);
        Event expected = new Event(user, file);
        expected.setId(1);

        when(eventRepository.update(expected)).thenReturn(expected);

        Event actual = eventService.updateEvent(expected);

        assertEquals(expected, actual);
    }

    @Test
    public void deleteEvent() {

        int eventId = 1;

        eventService.deleteEvent(eventId);

        verify(eventRepository, times(1)).delete(eventId);
    }

    @Test
    public void getByIdEventTest() {
        int eventId = 1;
        Event expected = new Event(new User(), new File());
        expected.setId(eventId);

        when(eventRepository.getById(eventId)).thenReturn(expected);

        Event actual = eventService.getByIdEvent(eventId);

        assertEquals(actual, expected);
    }
@Test
    public void getAllEventTest() {

        Event event = new Event(new User("Varchar", new ArrayList<>()), new File("swagger.json", "C:/api/rest/v1/storage") );
        event.setId(1);

        List<Event> expected = List.of(event);

        when(eventRepository.getAll()).thenReturn(expected);

        List<Event> actual = eventRepository.getAll();

        assertEquals(actual, expected);

    }
}

