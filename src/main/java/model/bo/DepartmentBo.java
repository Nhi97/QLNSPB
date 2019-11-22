package model.bo;

import model.bean.Department;
import model.bean.Employee;

import java.util.List;

public interface DepartmentBo {
    List<Employee> getListEmployees(String idpb);

    Department getDepartment(String id);

    int addDepartment(Department department);

    List<Department> getListDepartments();

    int editDepartment(Department department);

    int deleteDepartment(String id);
}
