package cn.itcast.Test;/*
 *
 *2019/12/15 0015
 *
 */

import cn.itcast.Uitls.JDBCUtils;
import cn.itcast.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Login {
    static Scanner sc =new Scanner(System.in);
    static JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        //2.调用方法
        boolean flag = new Login().login(username, password);
        if(flag){
        //登录成功
            System.out.println("登录成功！");
            System.out.println("您的用户名是"+username);
            Deom.show();
        }else{
            System.out.println("用户名或密码错误！");
        }

    }
    public  boolean login(String username,String password){
        if (username == null||password==null) {
            return false;
        }
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
           con= JDBCUtils.getConnection();
            String sql="select * from user where username=? and password=?";
            pstmt  = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,con );
        }
//        JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());
//        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
        return false;
    }
    public static void insert(){
        System.out.println("请输入用户名username");
        String username = sc.next();
        System.out.println("请输入密码password");
        String password = sc.next();

        String sql="insert into fruit values(?,?)";
        int insert = template.update(sql, username,password);
        if (insert>0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }
}
