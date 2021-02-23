package services;

import dao.EmployeeDao;
import models.Employee;
import org.hibernate.Session;

public class EmployeeService {

    private static EmployeeDao employeeDao = new EmployeeDao();
    private Session session;

    public EmployeeService() {
    }

    public static Employee findEmployee(int id) {
        return employeeDao.findById(id);
    }

    public static void saveEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    public static void deleteEmployee(Employee employee) {
        employeeDao.delete(employee);
    }

    public static void updateEmployee(Employee employee) {
        employeeDao.update(employee);
    }

}
