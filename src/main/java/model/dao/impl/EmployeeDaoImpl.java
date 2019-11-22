package model.dao.impl;

import jdbc.ConnectionProvider;
import jdbc.ConnectionProviderImpl;
import model.bean.Employee;
import model.dao.EmployeeDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    private Connection connection;
    private ConnectionProvider provider;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public EmployeeDaoImpl() {
        provider = new ConnectionProviderImpl();
        connection = provider.getConnection();
    }

    @Override
    public Employee getEmployee(String id) {
        String sql = "SELECT * FROM nhanvien WHERE IDNV = ?";
        Employee employee = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                employee = new Employee(resultSet.getString("IDNV"), resultSet.getString("Hoten"), resultSet.getString("IDPB"), resultSet.getString("Diachi"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public int addEmployee(Employee employee) {
        int result = 0;
        String sql = "INSERT INTO nhanvien VALUES(?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getId());
            preparedStatement.setString(2, employee.getFullName());
            preparedStatement.setString(3, employee.getIdPb());
            preparedStatement.setString(4, employee.getAddress());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Employee> getListEmployees(String idPb) {
        List<Employee> employees = new ArrayList<>();

        String sql = "SELECT * FROM nhanvien WHERE IDPB = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, idPb);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employees.add(new Employee(resultSet.getString("IDNV"), resultSet.getString("Hoten"), resultSet.getString("IDPB"), resultSet.getString("Diachi")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public List<Employee> getListEmployees() {
        List<Employee> employees = new ArrayList<>();

        String sql = "SELECT * FROM nhanvien";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                employees.add(new Employee(resultSet.getString("IDNV"), resultSet.getString("Hoten"), resultSet.getString("IDPB"), resultSet.getString("Diachi")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public int editEmployee(Employee employee) {
        int result = 0;
        String sql = "UPDATE nhanvien SET Hoten = ?, IDPB = ?, Diachi = ? WHERE IDNV = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getFullName());
            preparedStatement.setString(2, employee.getIdPb());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getId());
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int deleteEmployee(String id) {
        int result = 0;
        String sql = "DELETE FROM nhanvien WHERE IDNV = ?";
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
