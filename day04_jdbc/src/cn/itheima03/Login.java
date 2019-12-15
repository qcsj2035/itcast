package cn.itheima03;/*
 *
 *2019/12/12 0012
 *
 */

import cn.itheima02.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        for(int i=0; i<3; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入用户名");
            String username = sc.nextLine();
            System.out.println("请输入密码");
            String password = sc.nextLine();
            boolean flag = new Login().login(username, password);


            if (flag) {
                System.out.println("登录成功");
                break;
            } else {
                if (2 - i == 0) {
                    System.out.println("你的账户被锁定，请与管理员联系");
                } else {
                    //2,1,0
                    //i,0,1,2
                    System.out.println("登录失败，你还有" + (2 - i) + "次机会");
                }
            }

        }



//        if (flag){
//            System.out.println("登录成功");
//        }else {
//            System.out.println("登陆失败");
//        }

    }
    public boolean login(String username , String password){

        if (username==null||password==null){
            return false;
        }
        Statement stmt=null;
        Connection con=null;
        ResultSet rs=null;

        try {
            con = JDBCUtils.getConnection();
            String sql ="select * from user where name ='"+username+"' and '"+password+"'";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt ,con );
        }

        return false;
    }


}
