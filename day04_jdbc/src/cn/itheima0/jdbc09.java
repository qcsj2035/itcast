package cn.itheima0;/*
 *
 *2019/12/13 0013
 *
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Scanner;

public class jdbc09 {
    public static void main(String[] args) {
        for (int i = 0; i <3 ; i++) {


        Scanner sc =new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        boolean flag = login(username, password);
        if (flag){
            System.out.println("登录成功");
            break;
        }else {
            if (2-i==0){
                System.out.println("您的账户被锁住，请联系管理员");
            }else {
                System.out.println("您还有"+(2-i)+"机会");
            }

        }

        }

    }
    public static boolean login(String username,String password){
        if (username == null||password==null) {
            return false ;
        }

        Connection con =null;
        Statement stmt=null;
        ResultSet rs=null;

        try {
            con=jdbc08.getConnecction();
            String sql = "select * from user where name='"+username+"' and password='"+password+"'";
            stmt= con.createStatement();
            rs = stmt.executeQuery(sql);
            return rs.next();


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            jdbc08.close(rs,stmt ,con );
        }
        return false;
    }

}
