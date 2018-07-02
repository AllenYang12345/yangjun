package jdbc;

import java.sql.*;

/**
 * Created by Allen Yang
 * 2018/4/29 17:02
 */
public final class JdbcUtils {
    private static String url="jdbc:mysql://localhost:3306/entryform?useSSL=false&amp?useUnicode=true&characterEncoding=utf8";
    private static String user="root";
    private static String password="123456";
    private static JdbcUtils instance = null;
    private JdbcUtils(){}
    public static JdbcUtils getInstance(){
        if (instance ==null){  //应付并发，要加锁
            synchronized (JdbcUtils.class){
                if (instance==null){  //加锁范围缩小，双重检查应付线程问题，一次只可能有一个实例
                    instance=new JdbcUtils();
                }
            }
        }
        return instance;
    }
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    public static void free(ResultSet rs, Statement st,Connection conn){
        try{
            if(rs!=null)
                rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        } finally{
            try{
                if(st!=null)
                    st.close();
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                if(conn!=null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
