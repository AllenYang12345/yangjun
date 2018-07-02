package jdbc;

import java.sql.*;

/**
 * Created by Allen Yang
 * 2018/4/29 16:02
 */
public class Base {

    public static void main(String[] args) throws Exception{
        template();

    }

    static void template() throws Exception{
        Connection conn= null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn= JdbcUtils.getInstance().getConnection();
            st= conn.createStatement();
            rs= st.executeQuery("select * from student");

            while (rs.next()){
                System.out.println(rs.getObject(1)+"\t"+
                        rs.getObject(2)+"\t"+
                        rs.getObject(3)+"\t"+
                        rs.getObject(4)+"\t"+
                        rs.getObject(5)+"\t"+
                        rs.getObject(6)+"\t"+
                        rs.getObject(7)+"\t"+
                        rs.getObject(8)+"\t"+
                        rs.getObject(9)+"\t"+
                        rs.getObject(10)+"\t"+
                        rs.getObject(11)+"\t"+
                        rs.getObject(12)+"\t"+
                        rs.getObject(13)+"\t");
            }
        } finally {
            JdbcUtils.free(rs,st,conn);
        }
    }

    static void test() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");

        String url="jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf8";
        String user="root";
        String password="123456";
        Connection conn = DriverManager.getConnection(url, user, password);

        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery("select * from student");

        while (rs.next()){
            System.out.println(rs.getObject(1)+"\t"+
                               rs.getObject(2)+"\t"+
                               rs.getObject(3)+"\t"+
                               rs.getObject(4)+"\t"+
                               rs.getObject(5)+"\t"+
                               rs.getObject(6)+"\t"+
                               rs.getObject(7)+"\t"+
                               rs.getObject(8)+"\t"+
                               rs.getObject(9)+"\t"+
                               rs.getObject(10)+"\t"+
                               rs.getObject(11)+"\t"+
                               rs.getObject(12)+"\t"+
                               rs.getObject(13)+"\t"
                              );
            rs.close();
            st.close();
            conn.close();
        }
    }
}
