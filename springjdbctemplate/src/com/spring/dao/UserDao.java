package com.spring.dao;
import com.spring.domain.User;

/**
 * Created by Allen Yang
 * 2018/5/4 8:11
 */
public interface UserDao {


    public void addUser(User user);//增加一个用户

    public User getOneUser(int userId);//查询一个用户，按照ID查询

//    public User findUser(String loginName,String password);//登陆

    public void update(User user);//更新

    public void delete(int userId);//删除一个用户
}
