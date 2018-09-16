package com.system.service.impl;

import com.system.dao.UserDao;
import com.system.model.User;
import com.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author AllenYang
 * @date 18-9-9 下午11:32
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean hasMatchUser(String userName, String password) {
        int matchCount = userDao.getMatchCount(userName, password);
        return matchCount > 0;
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public int insertBatch(List<User> user) {
        return this.userDao.insertBatch(user);
    }

    @Override
    public User getUserByID(int userId) {
        return this.userDao.getUserByID(userId);
    }

    @Override
    public List<User> getUserByOnlineNumber(String onlineNumber) {
        return this.userDao.getUserByOnlineNumber(onlineNumber);
    }

    @Override
    public List<User> getUserByName(String userName) {
        return this.userDao.getUserByName(userName);
    }

    @Override
    public int updateUser(User user) {
        return this.userDao.updateUser(user);
    }

    @Override
    public int deleteUser(int userId) {
        return this.userDao.deleteUser(userId);
    }

}
