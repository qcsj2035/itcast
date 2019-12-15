package cn.itheima0;/*
 *
 *2019/12/13 0013
 *
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class jdbc009 {
    public static void main(String[] args) {
        for (int i = 0; i <3 ; i++) {


        Scanner sc =new Scanner(System.in);
        System.out.println("请输入用户名");
        String usename = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
            boolean flag = new jdbc009().login(usename, password);
            if (flag){
                System.out.println("登录成功");
            }else {
                if (2-i==0){
                    System.out.println("您的密码被锁住，请找管理员解锁");
                }else {
                    System.out.println("您还有"+(2-i)+"机会");
                }
            }

        }
    }
    public  boolean login(String username , String password){
        Connection con=null;
        PreparedStatement pstmt =null;
        ResultSet rs=null;
        try {
             con= jdbc08.getConnecction();
             String sql ="select * from user where name= ? and password= ? ";
             pstmt= con.prepareStatement(sql);//预编译
             pstmt.setString(1,username );
             pstmt.setString(2,password );
            rs= pstmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            jdbc08.close(rs,pstmt,con );
        }
        return false;
    }


}
