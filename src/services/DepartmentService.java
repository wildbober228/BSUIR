package services;

import dao.DepartmentDao;
import models.Departament;

public class DepartmentService {

    private static DepartmentDao departmentDao = new DepartmentDao();

    public DepartmentService() {

    }

    public static Departament findDepartament(int id) {
        return departmentDao.findById(id);
    }

    public static void saveDepartament(Departament discount) {
        departmentDao.save(discount);
    }

    public static void deleteDepartament(Departament discount) {
        departmentDao.delete(discount);
    }

    public static void updateDepartament(Departament discount) {
        departmentDao.update(discount);
    }

}
