package model.bo.impl;

import model.bean.Department;
import model.bean.Employee;
import model.bo.DepartmentBo;
import model.dao.DepartmentDao;
import model.dao.EmployeeDao;
import model.dao.impl.DepartmentDaoImpl;
import model.dao.impl.EmployeeDaoImpl;

import java.util.List;

public class DepartmentBoImpl implements DepartmentBo {
    private DepartmentDao departmentDao;
    private EmployeeDao employeeDao;

    public DepartmentBoImpl() {
        departmentDao = new DepartmentDaoImpl();
        employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public List<Employee> getListEmployees(String idpb) {
        return employeeDao.getListEmployees(idpb);
    }

    @Override
    public Department getDepartment(String id) {
        return departmentDao.getDepartment(id);
    }

    @Override
    public int addDepartment(Department department) {
        return departmentDao.addDepartment(department);
    }

    @Override
    public List<Department> getListDepartments() {
        return departmentDao.getListDepartments();
    }

    @Override
    public int editDepartment(Department department) {
        return departmentDao.editDepartment(department);
    }

    @Override
    public int deleteDepartment(String id) {
        return departmentDao.deleteDepartment(id);
    }
}
