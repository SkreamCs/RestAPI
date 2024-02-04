package abdul.restApi.service;

import abdul.restApi.model.Event;
import abdul.restApi.model.File;
import abdul.restApi.repository.FileRepository;

import java.util.List;

public class FileService {
    private final UserService userService;
    private final EventService eventService;
    private final FileRepository fileRepository;

    public FileService(UserService userService, EventService eventService, FileRepository fileRepository) {
        this.userService = userService;
        this.eventService = eventService;
        this.fileRepository = fileRepository;
    }

    public File saveFile(File file) {
       return fileRepository.save(file);
    }
    public File updateFile(File file) {
        return fileRepository.update(file);
    }
    public void deleteFile(int id) {
       fileRepository.delete(id);
    }
    public File getByIdFile(int id) {
        return fileRepository.getById(id);
    }
    public List<File> getAllFile() {
        return fileRepository.getAll();
    }
    public File uploadFile(File file, int userId) {
        file.setFilePath("C:/abdul/api/" + file.getName());
        Event event = new Event();
        event.setUser(userService.getByIdUser(userId));
        event.setFile(file);
        eventService.saveEvent(event);
        return file;
    }
}
