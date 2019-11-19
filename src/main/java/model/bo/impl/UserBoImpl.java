package model.bo.impl;

import model.bean.User;
import model.bo.UserBo;
import model.dao.UserDao;
import model.dao.impl.UserDaoImpl;

public class UserBoImpl implements UserBo{
    private UserDao userDao;
    public UserBoImpl(){
        userDao = new UserDaoImpl();
    }

    @Override
    public boolean checkLogin(User user) {
       return userDao.checkLogin(user);
    }
}
