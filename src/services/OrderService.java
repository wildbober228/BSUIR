package services;

import dao.OrderDao;
import models.Good;
import models.Order;
import org.hibernate.Session;

import java.util.List;

public class OrderService {

    private static OrderDao orderDao = new OrderDao();
    private Session session;

    public OrderService() {
    }

    public static Order findOrder(int id) {
        return orderDao.findById(id);
    }

    public static void saveOrder(Order order) {
        orderDao.save(order);
    }

    public static void deleteOrder(Order order) {
        orderDao.delete(order);
    }

    public static void updateOrder(Order order) {
        orderDao.update(order);
    }

    public List<Order> findAllOrders() {
        return orderDao.findAll();
    }

}
