package model.bo.impl;

import model.bean.Employee;
import model.bo.EmployeeBo;
import model.dao.EmployeeDao;
import model.dao.impl.EmployeeDaoImpl;

import java.util.List;

public class EmployeeBoImpl implements EmployeeBo {
    private EmployeeDao employeeDao;

    public EmployeeBoImpl() {
        employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public Employee getEmployee(String id) {
        return employeeDao.getEmployee(id);
    }

    @Override
    public int addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    @Override
    public List<Employee> getListEmployees(String idPb) {
        return employeeDao.getListEmployees(idPb);
    }

    @Override
    public List<Employee> getListEmployees() {
        return employeeDao.getListEmployees();
    }

    @Override
    public int editEmployee(Employee employee) {
        return employeeDao.editEmployee(employee);
    }

    @Override
    public int deleteEmployee(String id) {
        return employeeDao.deleteEmployee(id);
    }
}
