package jdbc;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * Created by Allen Yang
 * 2018/4/30 15:38
 */
public class CRUD {
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
    public static void main(String[] args) throws SQLException{
          read();
//        create();
//        delete();
//        update();
    }
    static void create() throws SQLException{
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
            ps.setString(1,"小八");
            ps.setString(2,"123456789");
            ps.setString(3,"Java");
            ps.setInt(4,20180321);
            ps.setString(5,"北京戏剧学院");
            ps.setString(6,"1432");
            ps.setString(7,"http://www.jnshu.com/daily/54684?dailyType=others&total=7&page=1&uid=21830&sort=0&orderBy=5");
            ps.setString(8,"越努力越幸运");
            ps.setString(9,"李晓来");
            ps.setString(10,"知乎");
            ps.setLong(11,dateTolong(new java.util.Date()));
            ps.setLong(12,dateTolong(new java.util.Date()));
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            JdbcUtils.free(rs,ps,conn);
        }
    }

    static void delete() throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getInstance().getConnection();
            String sql = "delete from student where id =?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,11);
            ps.executeUpdate();
            System.out.println("您已删除成功");

        } finally {
            JdbcUtils.free(rs,ps,conn);
        }
    }

    static void update() throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            conn = JdbcUtils.getInstance().getConnection();
            String sql = "update student set oath=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"老大最帅！");
            ps.executeLargeUpdate();
            System.out.println("修改成功！");
        }finally{
            JdbcUtils.free(rs,ps,conn);
        }
    }

    static void read() throws SQLException{
        Connection conn = null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getInstance().getConnection();
            String sql = "select ID,name,QQ,train_major,admiss_time,graduate_school,online_number,Daily_link,oath,coaching_senior,\n" +
                    "where_know,create_at,update_at\n" +
                    "from student where id=?;";
            ps= conn.prepareStatement(sql);
            ps.setInt(1,13);
            rs= ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt("ID")+"\n"
                        + rs.getString("name") + "\n"
                        + rs.getString("QQ") + "\n"
                        + rs.getString("train_major") + "\n"
                        + rs.getLong("admiss_time") + "\n"
                        + rs.getString("graduate_school") + "\n"
                        + rs.getString("online_number") + "\n"
                        + rs.getString("Daily_link") + "\n"
                        + rs.getString("oath") + "\n"
                        + rs.getString("coaching_senior") + "\n"
                        + rs.getString("where_know") + "\n"
                        + longToString(rs.getLong("create_at")) + "\n"
                        + longToString(rs.getLong("update_at")) + "\n"
                );
            }
        }finally {
            JdbcUtils.free(rs,ps,conn);
        }
    }
}
