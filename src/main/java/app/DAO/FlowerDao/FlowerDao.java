package app.DAO.FlowerDao;

import app.models.Flower.Flower;

import java.util.List;

public interface FlowerDao {
    void addFlower(Flower flower);
    List<Flower> getAllFlowers();
    Flower getFlower(int id);
}
