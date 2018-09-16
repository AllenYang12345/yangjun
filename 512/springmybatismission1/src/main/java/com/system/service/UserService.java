package com.system.service;

import com.system.model.User;

import java.util.List;

/**
 * Created by Allen Yang
 * 2018/6/2 16:51
 */
public interface UserService {

    //增
    public void insert(User user);//插入单条数据
    public int insertBatch(List<User> user);//批量插入
    //查
    public User getUserByID(int userId);//通过id查
    public List<User> getUserByOnlineNumber(String onlineNumber);//通过线上学号查
    public List<User> getUserByName(String userName);//通过名字查
    //改
    public int updateUser(User user);
    //删
    public int deleteUser(int userId);
    //检验登录是否成功
    public boolean hasMatchUser(String userName,String password);

}
