package cn.itheima0;/*
 *
 *2019/12/13 0013
 *
 */

import cn.itheima02.JDBCUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class jdbc04 {

    public static void main(String[] args) {
        List<Emp> all = new jdbc04().findAll();
        for (Emp emp : all) {
            System.out.println(emp);
        }

    }
    public List<Emp> findAll(){
        Connection con=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Emp> list =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
            String sql="select * from emp";
            stmt = con.prepareStatement(sql);
             rs = stmt.executeQuery();
             Emp emp =null;
             list=new ArrayList<Emp>();

             while (rs.next()){
                 Integer id = rs.getInt("id");
                 String ename = rs.getString("ename");
                 Integer job_id = rs.getInt("job_id");
                 Integer mgr = rs.getInt("mgr");
                 Date joindate = rs.getDate("joindate");
                 double salary = rs.getDouble("salary");
                 double bonus = rs.getDouble("bonus");
                 Integer dept_id = rs.getInt("dept_id");

                 emp=new Emp();

                 emp.setId(id);
                 emp.setEname(ename);
                 emp.setJob_id(job_id);
                 emp.setMgr(mgr);
                 emp.setJoindate(joindate);
                 emp.setSalary(salary);
                 emp.setBonus(bonus);
                 emp.setDept_id(dept_id);
                 list.add(emp);

             }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.close(rs,stmt,con );
        }
        return list;
    }
}
