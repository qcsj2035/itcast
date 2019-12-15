package cn.itheima0;/*
 *
 *2019/12/13 0013
 *
 */

import cn.itheima02.JDBCUtils;
import org.w3c.dom.ls.LSInput;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbc07 {
    public static void main(String[] args) {

        List<Emp> allfind = new jdbc07().Allfind();
        for (Emp emp : allfind) {
            System.out.println(emp);
        }
        System.out.println(allfind.size());

    }
    public List<Emp> Allfind(){
        Connection con=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Emp> list = null;


        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///db2", "root", "root");

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
                emp.setBonus(bonus);
                emp.setSalary(salary);
                emp.setDept_id(dept_id);
                list.add(emp);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return list;
    }

}
