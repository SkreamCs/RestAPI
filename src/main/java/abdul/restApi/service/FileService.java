package abdul.restApi.service;

import abdul.restApi.model.Event;
import abdul.restApi.model.File;
import abdul.restApi.repository.FileRepository;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

public class FileService {
    private final String filePath = "/Users/mustafatumgoev/Downloads/RestAPI/src/main/resources/storage/";
    private final int fileMaxSize = 100 * 1024;
    private final int memMaxSize = 100 * 1024;
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
    public File uploadFile(HttpServletRequest request, int userId) {
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        diskFileItemFactory.setRepository(new java.io.File(filePath));
        diskFileItemFactory.setSizeThreshold(memMaxSize);

        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setFileSizeMax(fileMaxSize);
        java.io.File file = null;
        try {
            List<FileItem> fileItemList = servletFileUpload.parseRequest(request);
            Iterator<FileItem> itemIterator = fileItemList.iterator();
            if(itemIterator.hasNext()) {
                FileItem fileItem = itemIterator.next();
                String fileName = fileItem.getName();
                if (!fileItem.isFormField()) {

                    if (fileItem.getName().lastIndexOf("\\") >= 0) {
                       file = new java.io.File(filePath +
                               fileName.substring(fileName.lastIndexOf("\\")));
                    }
                    else {
                        file = new java.io.File(filePath + fileName);
                    }
                    fileItem.write(file);
                }
            }
        } catch(Exception e) {
            e.getMessage();
        }
        String fileName = file.getName();
        Event event = new Event();
        File fileSave = new File((fileName.lastIndexOf("\\") >= 0 ) ?
                fileName.substring(fileName.lastIndexOf("\\")) :
                fileName, filePath);
        event.setUser(userService.getByIdUser(userId));
        event.setFile(fileSave);
        eventService.saveEvent(event);
        return fileSave;
    }

}
