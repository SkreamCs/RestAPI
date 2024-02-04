package abdul.restApi.controller;

import abdul.restApi.model.Event;
import abdul.restApi.model.File;
import abdul.restApi.model.User;
import abdul.restApi.service.FileService;
import abdul.restApi.service.UserService;


import java.util.List;


public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    public User createUser(User user) {
        return userService.saveUser(user);
    }
    public User updateUser(User user) {
        return userService.updateUser(user);
    }
    public void deleteUser(int id) {
        userService.deleteUser(id);
    }
    public User getByIdUser(int id) {
        return userService.getByIdUser(id);
    }
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

}
