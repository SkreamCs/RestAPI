package abdul.restApi.test;

import abdul.restApi.model.Event;
import abdul.restApi.model.File;
import abdul.restApi.model.User;
import abdul.restApi.repository.UserRepository;
import abdul.restApi.service.UserService;
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
public class UserServiceTest {
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userService;

    @Test
    public void createUser() {
        User user = new User("Abdul", new ArrayList<>());

        User expected = new User("Abdul", new ArrayList<>());
        expected.setId(1);

        when(userRepository.save(user)).thenReturn(expected);

        User actual = userService.saveUser(user);

        assertEquals(expected, actual);
    }

    @Test
    public void updateUser() {

        User expected = new User("Varchar", new ArrayList<>());
        expected.setId(1);

        when(userRepository.update(expected)).thenReturn(expected);

        User actual = userService.updateUser(expected);

        assertEquals(expected, actual);
    }

    @Test
    public void deleteUser() {

        int id = 1;

        userService.deleteUser(id);

        verify(userRepository, times(1)).delete(id);
    }

    @Test
    public void getByIdUserTest() {
        int id = 1;
        User expected = new User("Varchar", new ArrayList<>() );
        expected.setId(id);

        when(userRepository.getById(id)).thenReturn(expected);

        User actual = userService.getByIdUser(id);

        assertEquals(actual, expected);
    }
@Test
    public void getAllUserTest() {
        User user = new User("Varchar", new ArrayList<>());
        user.setId(1);

        List<User> expected = List.of(user);

        when(userRepository.getAll()).thenReturn(expected);

        List<User> actual = userRepository.getAll();

        assertEquals(actual, expected);

    }
}

