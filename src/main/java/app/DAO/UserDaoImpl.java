package app.DAO;

import app.models.User.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Arrays;
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
}
