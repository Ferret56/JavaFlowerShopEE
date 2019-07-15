package app.Service.FlowerService;

import app.models.Flower.Flower;

import java.util.List;

public interface FlowerService {
    void save(Flower flower);
    List<Flower> getAllFlowers();
    Flower getFlower(int id);
    void updateFlower(Flower flower);

}
