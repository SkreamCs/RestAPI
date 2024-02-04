package abdul.restApi.service;

import abdul.restApi.model.File;
import abdul.restApi.model.User;
import abdul.restApi.repository.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public User updateUser(User user) {
        return userRepository.update(user);
    }
    public void deleteUser(int id) {
        userRepository.delete(id);
    }
    public User getByIdUser(int id) {
        return userRepository.getById(id);
    }
    public List<User> getAllUser() {
        return userRepository.getAll();
    }
}
