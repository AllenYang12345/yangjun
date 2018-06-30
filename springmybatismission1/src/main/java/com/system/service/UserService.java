package com.system.service;

import com.system.dao.UserDao;
import com.system.model.User;

import java.util.List;

/**
 * Created by Allen Yang
 * 2018/6/2 16:51
 */
public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {

        this.userDao = userDao;
    }
    public UserDao getUserDao() {//用在insert
        return userDao;
    }

    public User getUser(int id) {

        return userDao.getUserByID(id);
    }

    public List<User> getUserbyName(String name){

        return userDao.getUserByName(name);
    }

    public List<User> getUserbyOnlineNumber(String online_number){

        return userDao.getUserByOnlineNumber(online_number);
    }


}
