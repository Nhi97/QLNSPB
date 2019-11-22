package model.dao.impl;

import jdbc.ConnectionProvider;
import jdbc.ConnectionProviderImpl;
import model.bean.Department;
import model.dao.DepartmentDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {
    private Connection connection;
    private ConnectionProvider connectionProvider;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public DepartmentDaoImpl() {
        connectionProvider = new ConnectionProviderImpl();
        connection = connectionProvider.getConnection();
    }

    @Override
    public Department getDepartment(String id) {
        String sql = "SELECT * FROM phongban WHERE IDPB = ?";
        Department department = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                department = new Department(resultSet.getString("IDPB"), resultSet.getString("TenPB"), resultSet.getString("Mota"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    @Override
    public int addDepartment(Department department) {
        int result = 0;
        String sql = "INSERT INTO phongban VALUES(?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, department.getId());
            preparedStatement.setString(2, department.getDepartmentName());
            preparedStatement.setString(3, department.getDescription());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Department> getListDepartments() {
        String sql = "SELECT * FROM phongban";
        List<Department> departments = new ArrayList<>();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                departments.add(new Department(resultSet.getString("IDPB"), resultSet.getString("TenPB"), resultSet.getString("Mota")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

    @Override
    public int editDepartment(Department department) {
        int result = 0;
        String sql = "UPDATE phongban SET TenPB = ?, Mota = ? WHERE IDPB = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, department.getDepartmentName());
            preparedStatement.setString(2, department.getDescription());
            preparedStatement.setString(3, department.getId());
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteDepartment(String id) {
        int result = 0;
        String sql = "DELETE FROM phongban WHERE IDPB = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
