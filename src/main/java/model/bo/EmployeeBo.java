package model.bo;

import model.bean.Employee;

import java.util.List;

public interface EmployeeBo {
    Employee getEmployee(String id);

    int addEmployee(Employee employee);

    List<Employee> getListEmployees(String idPb);

    List<Employee> getListEmployees();

    int editEmployee(Employee employee);

    int deleteEmployee(String id);
}
