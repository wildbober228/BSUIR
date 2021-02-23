package services;

import dao.DiscountDao;
import models.Discount;

import java.util.List;

public class DiscountService {

    private static DiscountDao discountDao = new DiscountDao();

    public DiscountService() {
    }

    public static Discount findDiscount(int id) {
        return discountDao.findById(id);
    }

    public static void saveDiscount(Discount discount) {
        discountDao.save(discount);
    }

    public static void deleteDiscount(Discount discount) {
        discountDao.delete(discount);
    }

    public static void updateDiscount(Discount discount) {
        discountDao.update(discount);
    }

    public List<Discount> findAllDiscounts() {
        return discountDao.findAll();
    }



}
