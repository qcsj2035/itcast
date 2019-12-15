package cn.JDBCUtils;/*
 *
 *2019/12/14 0014
 *
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCAccount {
    public static void main(String[] args) {
        List<Account> all = getAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }
    public static List<Account> getAll(){
        Connection con=null;
        PreparedStatement pstmt=null;

        ResultSet rs=null;
        List<Account> list =null;
        try {
            con = JDBCUtils.getConnection();
            String sql ="select * from account";

            pstmt = con.prepareStatement(sql);
            rs= pstmt.executeQuery();

            Account account =null;
            list=new ArrayList<Account>();

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double balance = rs.getDouble("balance");
                account=new Account(id,name,balance);
                list.add(account);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt ,con );
        }
        return list;
    }

}
