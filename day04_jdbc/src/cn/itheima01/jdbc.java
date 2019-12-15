package cn.itheima01;/*
 *
 *2019/12/12 0012
 *
 */

import javax.xml.transform.Source;
import java.sql.*;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

public class jdbc {
    public static void main(String[] args) {
        List<emp> emps =  new jdbc().find();
        System.out.println(emps);
        System.out.println(emps.size());
        for (emp emp : emps) {
            System.out.println(emp);
        }
    }
   public   List<emp> find(){
       Connection con=null;
       Statement stmt =null;
       ResultSet rs=null;
       List<emp> array =null;


       try {
           Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
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
           if (rs!=null){
               try {
                   rs.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
           if (stmt!=null){
               try {
                   stmt.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
           if (con!=null){
               try {
                   con.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
       }
       return array;
   }


}
