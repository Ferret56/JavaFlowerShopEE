package app.DAO;

import app.models.User.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


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
}
