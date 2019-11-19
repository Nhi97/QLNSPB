package model.dao.impl;

import jdbc.ConnectionProviderImpl;
import model.bean.User;
import model.dao.UserDao;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    private Connection connection;
    private ConnectionProviderImpl connectionProviderImpl;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public UserDaoImpl() {
        connectionProviderImpl = new ConnectionProviderImpl();
        connection = connectionProviderImpl.getConnection();
    }

    @Override
    public boolean checkLogin(User user) {

        String sql = "SELECT * FROM user WHERE username = ? and password = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());

            resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
