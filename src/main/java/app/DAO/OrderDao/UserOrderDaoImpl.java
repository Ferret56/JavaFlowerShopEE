package app.DAO.OrderDao;

import app.models.Order.OrderItem;
import app.models.Order.UserOrder;
import app.models.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserOrderDaoImpl implements UserOrderDao {

    @Override
    public void createOrder(User user, List<OrderItem> orderItemList) {
        EntityManager em = Persistence.createEntityManagerFactory("data").createEntityManager();
        UserOrder userOrder = new UserOrder(user,orderItemList);
        em.getTransaction().begin();
        em.persist(userOrder);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void removeOrder(int id) {
        EntityManager em = Persistence.createEntityManagerFactory("data").createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(UserOrder.class, id));
        em.getTransaction().commit();
        em.close();
    }



}
