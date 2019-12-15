package cn.itheima0;/*
 *
 *2019/12/13 0013
 *
 */

import java.sql.*;

public class jdbc03 {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/day16", "root", "root");
             String sql ="select * from account order by id DESC ";
             stmt = con.createStatement();
             rs = stmt.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString("name");
                double balance = rs.getDouble("balance");
                System.out.println(id+"---"+name+"---"+balance);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
