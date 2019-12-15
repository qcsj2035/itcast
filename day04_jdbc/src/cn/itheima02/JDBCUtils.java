package cn.itheima02;/*
 *
 *2019/12/12 0012
 *
 */

import cn.itheima01.emp;
import cn.itheima01.jdbc;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    /**
     * 文件的读取，只需要读取一次即可拿到这些值。使用静态代码块
     */
    static {
        //读取资源文件，获取值。

        try {
            //1. 创建Properties集合类。
            Properties pro = new Properties();

                //获取src路径下的文件的方式--->ClassLoader 类加载器
                ClassLoader classLoader = JDBCUtils.class.getClassLoader();
                URL res = classLoader.getResource("jdbc.properties");
                String path = res.getPath();
//                System.out.println(path);///D:/IdeaProjects/itcast/out/production/day04_jdbc/jdbc.properties
//            2. 加载文件
//             pro.load(new FileReader("D:\\IdeaProjects\\itcast\\day04_jdbc\\src\\jdbc.properties"));
            pro.load(new FileReader(path));

            //3. 获取数据，赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            //4. 注册驱动
//            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * 获取连接
     * @return 连接对象
     */
    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 释放资源
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt, Connection conn){
        if( stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if( conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 释放资源
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn){
        if( rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if( stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if( conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }






    public static void main(String[] args) {
        List<emp> emps =  new jdbc().find();
        System.out.println(emps);
        System.out.println(emps.size());
    }
    public List<emp> find(){
        Connection con=null;
        Statement stmt =null;
        ResultSet rs=null;
        List<emp> array =null;


        try {
           con= JDBCUtils.getConnection();


            String sql ="select * from emp";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            emp e1 =null;
            array =new ArrayList<>();

            while (rs.next()){
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                e1 =new emp();
                e1.setId(id);
                e1.setEname(ename);
                e1.setJob_id(job_id);
                e1.setMgr(mgr);
                e1.setSalary(salary);
                e1.setJoindate(joindate);
                e1.setBonus(bonus);
                e1.setDept_id(dept_id);
                array.add(e1);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,con );
        }
        return array;
    }

}
