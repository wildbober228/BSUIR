package services;

import dao.GoodDao;
import models.Good;

public class GoodService {

    private static GoodDao goodDao = new GoodDao();

    public GoodService() {
    }

    public static Good findGood(int id) {
        return goodDao.findById(id);
    }

    public static void saveGood(Good good) {
        goodDao.save(good);
    }

    public void deleteGood(Good good) {
        goodDao.delete(good);
    }

    public void updateGood(Good good) {
        goodDao.update(good);
    }
}