package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    void save(User user);
    User show(Long id);
    void update(int id, User user);
    public void delete(int id);
}
