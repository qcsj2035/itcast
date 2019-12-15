package cn.itheima0;/*
 *
 *2019/12/13 0013
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc02 {
    public static void main(String[] args) throws ClassNotFoundException {
//       1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=null;
        Statement stmt=null;
        try {
//            2.获取数据库连接对象
            con= DriverManager.getConnection("jdbc:mysql:///day16", "root", "root");
//              3.定义sql
            String sql="update account set balance=500 where id=1";
//            4.获取执行sql对象 Statement
            stmt = con.createStatement();
//            5.执行  sql
            int count = stmt.executeUpdate(sql);
//            6.处理结果
            System.out.println(count);
            if (count>0){
                System.out.println("修改成功");
            }else {
                System.out.println("修改失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
//            7.释放资源
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
