package cn.itheima;/*
 *
 *2019/12/12 0012
 *
 */

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbc {
    public static void main(String[] args) throws Exception {
        //1. 导入驱动jar包
        //2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.jdbc.Driver");
        //3.获取数据库连接对象
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/day16", "root", "root");
        //4.定义sql语句
//        String sql ="update account set balance=1500 where id=1";
//        String sql ="insert into account values(null,'王五',3000)";
//        String sql="update account set balance = 2100 where id=4";
        String sql="create table stu(id int primary key,name VARCHAR(32))";
        //5.获取执行sql的对象 Statement
        Statement stmt = con.createStatement();
        //6.执行sql
        int count = stmt.executeUpdate(sql);
        //7.处理结果
        System.out.println(count);
//        if (count>0){
//            System.out.println("添加成功");
//        }
//        else {
//            System.out.println("添加失败");
//        }
        if (count==0){
            System.out.println("创建表成功");
        }else {
            System.out.println("创建表失败");
        }
        //8.释放资源
        stmt.close();
        con.close();
    }


}
