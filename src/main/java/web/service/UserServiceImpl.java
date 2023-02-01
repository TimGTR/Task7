package web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;



    @Override
    @Transactional
    public List<User> allUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public User show(Long id) {
        return userDao.show(id);
    }

    @Override
    @Transactional
    public void update(Long id, User user) {
        userDao.update(id, user);
        System.out.println("id " + id + user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
        System.out.println("delete " + id);
    }
}
