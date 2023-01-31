package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void save(User user);

    User show(Long id);
    void update(int id, User user);
    public void delete(int id);
}
