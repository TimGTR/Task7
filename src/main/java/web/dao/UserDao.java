package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDao {
    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public UserDao(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Transactional
    public List<User> index() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Transactional
    public User show(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void save(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.persist(user);
    }

    @Transactional
    public void update(int id, User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User updatedUser = entityManager.find(User.class, id);
        updatedUser.setName(user.getName());
        updatedUser.setSurname(user.getSurname());
    }

    @Transactional
    public void delete(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.remove(id);
    }


}
