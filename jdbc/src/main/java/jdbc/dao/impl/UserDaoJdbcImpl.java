package jdbc.dao.impl;

import jdbc.JdbcUtils;
import jdbc.dao.DaoException;
import jdbc.dao.UserDao;
import jdbc.domain.User;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * Created by Allen Yang
 * 2018/4/29 15:25
 */
public class UserDaoJdbcImpl implements UserDao {
    /*  Long类型转换为String */
    public static String longToString(Long mysqlBigInt){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        /*  java.util.Date是毫秒单位 mysqlBigint是秒单位 */
        java.util.Date judt = new Date(mysqlBigInt * 1000);
        /*  返回格式化时间戳字符串 */
        return simpleDateFormat.format(judt);
    }
    /*  date转换为long */
    public static Long dateTolong(java.util.Date judt){
        /*  date.getTime()所返回的是一个long型的毫秒数,除以1000得到秒  */
        return judt.getTime()/1000;
    }
    @Override
    public void addUser(User user) {
        Connection conn= null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getInstance().getConnection();
            String sql = "insert into student(name," +
                    "QQ,train_major,admiss_time," +
                    "graduate_school,online_number," +
                    "Daily_link,oath,coaching_senior," +
                    "where_know,create_at,update_at) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getQQ());
            ps.setString(3,user.getTrain_major());
            ps.setLong(4,user.getAdmiss_time());
            ps.setString(5,user.getGraduate_school());
            ps.setString(6,user.getOnline_number());
            ps.setString(7,user.getDaily_link());
            ps.setString(8,user.getOath());
            ps.setString(9,user.getCoaching_senior());
            ps.setString(10,user.getWhere_know());
            ps.setLong(11,dateTolong(new java.util.Date()));
            ps.setLong(12,dateTolong(new java.util.Date()));
            ps.executeLargeUpdate();
            System.out.println("您已创建成功");

        }catch(SQLException e){
            throw new DaoException(e.getMessage());
        }finally{
            JdbcUtils.free(rs,ps,conn);
        }
    }

    @Override
    public User getUser(int userId) {
        Connection conn = null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        User user =null;
        try{
            conn = JdbcUtils.getInstance().getConnection();
            String sql = "select ID,name,QQ,train_major,admiss_time,graduate_school,online_number,Daily_link,oath,coaching_senior,\n" +
                    "where_know,create_at,update_at\n" +
                    "from student where id=?;";
            ps= conn.prepareStatement(sql);
            ps.setInt(1,userId);
            rs= ps.executeQuery();
            while(rs.next()){
                user =new User();
                user.setId(rs.getInt("ID"));
                user.setName(rs.getString("name"));
                user.setQQ(rs.getString("QQ"));
                user.setTrain_major(rs.getString("train_major"));
                user.setAdmiss_time(rs.getLong("admiss_time"));
                user.setGraduate_school(rs.getString("graduate_school"));
                user.setOath(rs.getString("online_number"));
                user.setDaily_link(rs.getString("Daily_link"));
                user.setOath(rs.getString("oath"));
                user.setCoaching_senior(rs.getString("coaching_senior"));
                user.setWhere_know(rs.getString("where_know"));
                user.setCreate_at(rs.getLong("create_at"));
                user.setUpdate_at(rs.getLong("update_at"));
            }
            System.out.println("您已获取用户信息");
        }catch (SQLException e){
            throw new DaoException(e.getMessage());
        }
        finally {
            JdbcUtils.free(rs,ps,conn);
        }
        return user;
    }

    @Override
    public void update(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getInstance().getConnection();
            String sql = "update student set name=?,QQ=?,train_major=?,admiss_time=?" +
                    ",graduate_school=?,online_number=?," +
                    "Daily_link=?,oath=?,coaching_senior=?" +
                    ",create_at,update_at where ID=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getQQ());
            ps.setString(3,user.getTrain_major());
            ps.setString(4,longToString(user.getAdmiss_time()));
            ps.setString(5,user.getGraduate_school());
            ps.setString(6,user.getOnline_number());
            ps.setString(7,user.getDaily_link());
            ps.setString(8,user.getOath());
            ps.setString(9,user.getCoaching_senior());
            ps.setString(10,user.getWhere_know());
            ps.setString(11,longToString(user.getCreate_at()));
            ps.setString(12,longToString(user.getUpdate_at()));
            ps.executeLargeUpdate();
            System.out.println("您已更新成功");
        }catch (SQLException e){
            throw new DaoException(e.getMessage());
        }
        finally{
            JdbcUtils.free(rs,ps,conn);
        }
    }

    @Override
    public void delete(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getInstance().getConnection();
            String sql = "delete from student where id =?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,user.getId());
            ps.executeUpdate();
            System.out.println("您已删除成功");

        }catch(SQLException e){
            throw new DaoException(e.getMessage());
        } finally {
            JdbcUtils.free(rs,ps,conn);
        }
    }
}
