package app.DAO.UserDao;

import app.models.User.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public void addUser(User user) {
        EntityManager em = Persistence.createEntityManagerFactory("data").createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<User> getAllUsers() {
        EntityManager em = Persistence.createEntityManagerFactory("data").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<User> query = em.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User getUser(int id) {
        EntityManager em = Persistence.createEntityManagerFactory("data").createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        em.getTransaction().commit();
        em.close();
        return user;
    }

    @Override
    public void updateUser(User user) {
        EntityManager em = Persistence.createEntityManagerFactory("data").createEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }
}
