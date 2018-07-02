package com.spring.dao.impl;

import com.spring.dao.UserDao;
import com.spring.domain.User;
import com.spring.test.UserMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by Allen Yang
 * 2018/5/4 8:29
 */
public class UserDaoJdbcImpl extends JdbcDaoSupport implements UserDao {

    @Override
    public void addUser(User user) {

            String sql = "insert into student(name," +
                    "QQ,train_major,admiss_time," +
                    "graduate_school,online_number," +
                    "Daily_link,oath,coaching_senior," +
                    "where_know,create_at,update_at) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            this.getJdbcTemplate().update(sql,user.getName(),user.getQQ(),user.getTrain_major(),
                    user.getAdmiss_time(),user.getGraduate_school(),user.getOnline_number(),
                    user.getDaily_link(),user.getOath(),user.getCoaching_senior(), user.getWhere_know(),
                    user.getCreate_at(), user.getUpdate_at());
    }

    @Override
    public User getOneUser(int userId) {

            String sql = "select ID,name,QQ,train_major,admiss_time,graduate_school,online_number,Daily_link,oath,coaching_senior," +
                    "where_know,create_at,update_at" +
                    " from student where id=?";
        return this.getJdbcTemplate().queryForObject(sql,new UserMapper(),userId);
    }

    @Override
    public void update(User user) {

        String sql = "update student set name=?,QQ=?,train_major=?,admiss_time=?" +
                ",graduate_school=?,online_number=?," +
                "Daily_link=?,oath=?,coaching_senior=?,where_know=?" +
                ",create_at=?,update_at=? where ID=?";
        this.getJdbcTemplate().update(sql, user.getName(), user.getQQ(), user.getTrain_major(),
                user.getAdmiss_time(), user.getGraduate_school(), user.getOnline_number(),
                user.getDaily_link(), user.getOath(), user.getCoaching_senior(),
                user.getWhere_know(), user.getCreate_at(), user.getUpdate_at(),user.getId());
    }

    @Override
    public void delete(int userId) {

            String sql = "delete from student where id =?";
            this.getJdbcTemplate().update(sql,userId);
    }
}
