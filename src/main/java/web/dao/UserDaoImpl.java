package web.dao;


import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }


    @Override
    public User show(Long id) {
        return entityManager.find(User.class, id);
    }



    @Override
    public void update(Long id, User user) {
        User updatedUser = entityManager.find(User.class, id);
        updatedUser.setName(user.getName());
        updatedUser.setSurname(user.getSurname());
    }

    @Override
    public void delete(Long id) {
        User user = show(id);
        entityManager.remove(user);
    }


}
