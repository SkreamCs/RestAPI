package abdul.restApi.controller;

import abdul.restApi.model.File;
import abdul.restApi.service.FileService;

import java.util.List;


public class FileController {
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }
    public File createFile(File file) {
       return fileService.saveFile(file);
    }
    public File updateFile(File file) {
        return fileService.updateFile(file);
    }
    public void deleteFile(int id) {
        fileService.deleteFile(id);
    }
    public File uploadFile(File file, int userId){
        return fileService.uploadFile(file, userId);
    }
    public File getByIdFile(int id) {
        return fileService.getByIdFile(id);
    }
    public List<File> getAllFile() {
       return fileService.getAllFile();
    }
}