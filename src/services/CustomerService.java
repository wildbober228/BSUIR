package services;

import dao.CustomerDao;
import models.Customer;
import models.Discount;
import org.hibernate.Session;
import org.hibernate.Query;

import java.util.List;


public class CustomerService {

    private static CustomerDao customerDao = new CustomerDao();
    private Session session;

    public CustomerService() {
    }

    public static Customer findCustomer(int id) {
            return customerDao.findById(id);
    }

    public static void saveCustomer(Customer customer) {
        customerDao.save(customer);
    }

    public static void deleteCustomer(Customer customer) {
        customerDao.delete(customer);
    }

    public static void updateCustomer(Customer customer) {
        customerDao.update(customer);
    }

    public List<Customer> findAllCustomers() {
        return customerDao.findAll();
    }
}
