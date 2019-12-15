package cn.JDBCUtils;/*
 *
 *2019/12/14 0014
 *
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement pstmt=null;

        try {
          con = JDBCUtils.getConnection();
          String sql ="insert into account values(null, ?,?)";
          pstmt = con.prepareStatement(sql);
          pstmt.setString(1,"柳岩" );
          pstmt.setDouble(2,3000 );
            int count = pstmt.executeUpdate();
            System.out.println(count);


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,con );
        }

    }
}
