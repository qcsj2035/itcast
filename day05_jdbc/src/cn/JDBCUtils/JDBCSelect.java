package cn.JDBCUtils;/*
 *
 *2019/12/14 0014
 *
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCSelect {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        try {
             con = JDBCUtils.getConnection();
             String sql="select * from account where id=?";
             pstmt = con.prepareStatement(sql);
             pstmt.setInt(1,5 );
             rs = pstmt.executeQuery();

             while (rs.next()){
                 int id = rs.getInt("id");
                 String name = rs.getString("name");
                 double balance = rs.getDouble("balance");
                 System.out.println(id+"---"+name+"---"+balance);
             }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt ,con );
        }
    }


}
