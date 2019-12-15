package cn.itheima0;/*
 *
 *2019/12/13 0013
 *
 */

import cn.itheima02.JDBCUtils;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class jdbc08 {
     private  static String url;
     private static  String user;
     private static  String password;
     private static  String driver;

     static {


         Properties prop =new Properties();

//
         InputStream is = jdbc08.class.getClassLoader().getResourceAsStream("jdbc.properties");
         System.out.println(is);
         //2. 加载文件
         try {
             prop.load(is);
         } catch (IOException e) {
             e.printStackTrace();
         }

//         String path = jdbc08.class.getClassLoader().getResource("jdbc.properties").getPath();
//
//         try {
//             prop.load(new FileReader(path));
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
         url=prop.getProperty("url");
         user=prop.getProperty("user");
         password=prop.getProperty("password");
         driver=prop.getProperty("driver");


     }

    public static Connection getConnecction() throws SQLException {
        return DriverManager.getConnection(url, user, password);

    }
    public static void close(Statement stmt,Connection con){
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void  close(ResultSet rs, Statement stmt, Connection con){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        List<Emp> allfind = allfind();
        for (Emp emp : allfind) {
            System.out.println(emp);
        }

    }
    public static   List<Emp> allfind(){

        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        List<Emp> list =null;
        try {
           con  = jdbc08.getConnecction();
           String sql="select * from emp";
            pstmt = con.prepareStatement(sql);
             rs = pstmt.executeQuery();
            Emp emp =null;
            list=new ArrayList<Emp>();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String ename = rs.getString("ename");
                Integer job_id = rs.getInt("job_id");
                Integer mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                Integer dept_id = rs.getInt("dept_id");
                emp = new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setBonus(bonus);
                emp.setSalary(salary);
                emp.setDept_id(dept_id);
                list.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            jdbc08.close(rs,pstmt ,con );
        }
        return list;
    }

}
