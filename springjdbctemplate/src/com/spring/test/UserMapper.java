package com.spring.test;

import com.spring.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Allen Yang
 * 2018/5/4 9:18
 */
public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet,int rowNum) throws SQLException{
        User user= new User();
        user.setId(resultSet.getInt(1));
        user.setName(resultSet.getString(2));
        user.setQQ(resultSet.getString(3));
        user.setTrain_major(resultSet.getString(4));
        user.setAdmiss_time(resultSet.getLong(5));
        user.setGraduate_school(resultSet.getString(6));
        user.setOnline_number(resultSet.getString(7));
        user.setDaily_link(resultSet.getString(8));
        user.setOath(resultSet.getString(9));
        user.setCoaching_senior(resultSet.getString(10));
        user.setWhere_know(resultSet.getString(11));
        user.setCreate_at(resultSet.getLong(12));
        user.setUpdate_at(resultSet.getLong(13));

        return user;
    }
}
