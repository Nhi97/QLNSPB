package model.dao;

import model.bean.Department;

import java.util.List;

public interface DepartmentDao {
    Department getDepartment(String id);

    int addDepartment(Department department);

    List<Department> getListDepartments();

    int editDepartment(Department department);

    int deleteDepartment(String id);
}
