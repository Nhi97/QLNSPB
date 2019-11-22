package model.dao;

import model.bean.Employee;

import java.util.List;

public interface EmployeeDao {

    Employee getEmployee(String id);

    int addEmployee(Employee employee);

    List<Employee> getListEmployees(String idPb);

    List<Employee> getListEmployees();

    int editEmployee(Employee employee);

    int deleteEmployee(String id);

}
