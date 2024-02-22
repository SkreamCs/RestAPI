package abdul.restApi.test;

import abdul.restApi.model.File;
import abdul.restApi.repository.FileRepository;
import abdul.restApi.service.FileService;
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
public class FileServiceTest {
    @Mock
    FileRepository fileRepository;
    @InjectMocks
    FileService fileService;

    @Test
    public void createFile() {

        File file = new File("postman.json", "C:/user/RestAPI/src/main/resources/storage/");

        File expected = new File("postman.json", "C:/user/RestAPI/src/main/resources/storage/");
        expected.setId(1);

        when(fileRepository.save(file)).thenReturn(expected);

        File actual = fileService.saveFile(file);

        assertEquals(expected, actual);
    }

    @Test
    public void updateFile() {

        File expected = new File("swagger.json", "C:/user/RestAPI/src/main/resources/storage/");
        expected.setId(1);

        when(fileRepository.update(expected)).thenReturn(expected);

        File actual = fileService.updateFile(expected);

        assertEquals(expected, actual);
    }

    @Test
    public void deleteFile() {

        int id = 1;

        fileService.deleteFile(id);

        verify(fileRepository, times(1)).delete(id);
    }

    @Test
    public void getByIdFileTest() {
        int id = 1;
        File expected = new File("swagger.json", "C:/user/RestAPI/src/main/resources/storage/");
        expected.setId(id);

        when(fileRepository.getById(id)).thenReturn(expected);

        File actual = fileService.getByIdFile(id);

        assertEquals(actual, expected);
    }
@Test
    public void getAllFileTest() {
        File file = new File("swagger.json", "C:/user/RestAPI/src/main/resources/storage/");
        file.setId(1);

        List<File> expected = List.of(file);

        when(fileRepository.getAll()).thenReturn(expected);

        List<File> actual = fileRepository.getAll();

        assertEquals(actual, expected);

    }
}
