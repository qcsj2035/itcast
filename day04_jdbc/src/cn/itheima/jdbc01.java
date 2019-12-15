package cn.itheima;/*
 *
 *2019/12/12 0012
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc01 {
    public static void main(String[] args) {

        //1. 导入驱动jar包
        //2.注册驱动
//        Connection con=null;
//        Statement stmt=null;
//        int count =0;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            //3.获取数据库连接对象
//            try {
//                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/day16", "root", "root");
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            //4.定义sql语句
//            String sql ="insert into account values(null,'柳岩',3000)" ;
//            //5.获取执行sql的对象 Statement
//            try {
//                 stmt = con.createStatement();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//            //6.执行sql
//            try {
//                 count = stmt.executeUpdate(sql);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            //7.处理结果
//            System.out.println(count);
//            if(count>0){
//                System.out.println("添加成功");
//            }
//            else {
//                System.out.println("添加失败");
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }finally {
//            //8.释放资源
//            if (con!=null){
//                try {
//                    con.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (stmt!=null){
//                try {
//                    stmt.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        2注册
        Connection con=null;
        Statement stmt=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            3
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/day16", "root", "root");
//            4
            String sql ="delete from account where id=5";

//            5
            stmt = con.createStatement();
//            6.
            int count = stmt.executeUpdate(sql);
            System.out.println(count);
            if (count>0){
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
