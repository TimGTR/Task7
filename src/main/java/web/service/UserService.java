package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void save(User user);
    User findOne(Integer id);
    void update(Integer id, User user);
    public void delete(Integer id);
}
