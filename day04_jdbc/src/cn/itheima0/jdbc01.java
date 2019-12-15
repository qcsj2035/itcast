package cn.itheima0;/*
 *
 *2019/12/13 0013
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc01 {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        try {

//            1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
//            2.获取数据库连接对象
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/day16", "root", "root");
//            3.定义sql
//            String sql ="insert into account values(null,'林文生',3000)";
//            String sql ="delete from account where id=6";
              String sql ="update account set name='赵四',balance='2500' where id=3";
//            4.获取执行sql Statement对象
            stmt = con.createStatement();
//            5.执行sql
            int count = stmt.executeUpdate(sql);
            System.out.println(count);
            if (count>0){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
