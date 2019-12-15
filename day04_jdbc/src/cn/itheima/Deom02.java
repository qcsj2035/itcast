package cn.itheima;/*
 *
 *2019/12/12 0012
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Deom02 {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/day16", "root", "root");
            String sql ="SELECT  * from account ";
            stmt= con.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                double balance = resultSet.getDouble(3);
                System.out.println(id+"---"+name+"---"+balance);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
