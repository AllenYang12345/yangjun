package jdbc.dao;

import jdbc.domain.User;

/**
 * Created by Allen Yang
 * 2018/4/29 15:13
 */
public interface UserDao {

    public void addUser(User user);//增加一个用户

    public User getUser(int userId);//查询一个用户

//    public User findUser(String loginName,String password);//登陆

    public void update(User user);//更新

    public void delete(User user);//删除一个用户

}
