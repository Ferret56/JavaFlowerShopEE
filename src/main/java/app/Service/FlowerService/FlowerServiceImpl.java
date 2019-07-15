package app.Service.FlowerService;

import app.DAO.FlowerDao.FlowerDao;
import app.models.Flower.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowerServiceImpl implements FlowerService {

    private FlowerDao dao;

    @Autowired
    public FlowerServiceImpl(FlowerDao dao){this.dao = dao;}

    @Override
    public void save(Flower flower) {
        dao.addFlower(flower);
    }

    @Override
    public List<Flower> getAllFlowers() {
        return dao.getAllFlowers();
    }

    @Override
    public Flower getFlower(int id) {
        return dao.getFlower(id);
    }

    @Override
    public void updateFlower(Flower flower) {
        dao.updateFlower(flower);
    }
}
