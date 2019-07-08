package app.DAO.FlowerDao;


import app.models.Flower.Flower;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class FlowerDaoImpl implements FlowerDao {

    @Override
    public void addFlower(Flower flower) {
        EntityManager em = Persistence.createEntityManagerFactory("data")
                                      .createEntityManager();

        em.getTransaction().begin();
        em.persist(flower);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Flower> getAllFlowers() {
        EntityManager em = Persistence.createEntityManagerFactory("data")
                                      .createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Flower> query = em.createQuery("from Flower", Flower.class);
        return query.getResultList();

    }

    @Override
    public Flower getFlower(int id) {
        EntityManager em = Persistence.createEntityManagerFactory("data")
                .createEntityManager();

        em.getTransaction().begin();
        Flower flower = em.find(Flower.class,id);
        em.getTransaction().commit();
        em.close();
        return flower;
    }
}
