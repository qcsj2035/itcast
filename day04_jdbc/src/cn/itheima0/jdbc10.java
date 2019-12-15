package cn.itheima0;/*
 *
 *2019/12/13 0013
 *
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbc10 {
    public static void main(String[] args) {

        Connection con=null;
        PreparedStatement pstmt=null;
        int count =0;

        try {

             con= jdbc08.getConnecction();
            con.setAutoCommit(false);
             String sql ="update account set balance=balance + ? where id = ?";
             pstmt = con.prepareStatement(sql);
             pstmt.setDouble(1,-500 );
             pstmt.setInt(2,1 );
             count= pstmt.executeUpdate();
//                int coun=10/0;
             pstmt.setDouble(1,500 );
             pstmt.setInt(2,2 );
             count = pstmt.executeUpdate();
             con.commit();


        } catch (Exception e) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

            e.printStackTrace();
        }finally {
            jdbc08.close(pstmt,con );
        }
    }
}
