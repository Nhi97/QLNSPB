package model.dao;

import model.bean.User;

public interface UserDao {
    boolean checkLogin(User user);
}
