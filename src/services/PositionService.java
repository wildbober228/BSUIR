package services;

import dao.PositionDao;
import models.Position;

public class PositionService {

    private static PositionDao positionDao = new PositionDao();

    public PositionService() {
    }

    public static Position findPosition(int id) {
        return positionDao.findById(id);
    }

    public static void savePosition(Position position) {
        positionDao.save(position);
    }

    public static void deletePosition(Position position) {
        positionDao.delete(position);
    }

    public static void updatePosition(Position position) {
        positionDao.update(position);
    }

}
