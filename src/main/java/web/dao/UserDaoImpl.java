package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(int id) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id = :id", User.class)
                .setParameter("id", id);
        return query.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
        System.out.println(user);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

}