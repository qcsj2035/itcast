package cn.SpringJDBC;/*
 *
 *2019/12/14 0014
 *
 */

import cn.JDBCUtils.JDBCUtils;
import cn.domain.Emp;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class template02 {

    /**
     *Junit 单元测试可以让方法独立
     */
    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 修改的
     */
    @Test
    public void test1(){
        String sql="update emp set salary=? where id=?";
        int count = template.update(sql, 10000, 1001);
        System.out.println(count);
    }

    /**
     * 添加数据
     */
    @Test
    public void test2(){
        String sql ="insert into emp(id,ename,dept_id)values(?,?,?)";
        int count = template.update(sql, 1015, "郭靖", 20);
        System.out.println(count);
    }

    /**
     * 删除数据
     */
    @Test
    public void test3(){
        String sql ="delete from emp where id=?";
        int count = template.update(sql, 1015);
        System.out.println(count);
    }

    /**
     *queryForMap返回单行，预期只能是单行
     */
    @Test
    public void test4(){
        String sql ="select * from emp where id= ?";
        Map<String, Object> stringObjectMap = template.queryForMap(sql, 1001);
        System.out.println(stringObjectMap);
    }

    /**
     *queryForList的查询
     */
    @Test
    public void test5(){
        String sql ="select *  from emp ";
        List<Map<String, Object>> maps = template.queryForList(sql);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }

    /**
     * 比较常用的方法查询（BeanPropertyRowMapper）
     */
    @Test
    public void test6(){
        String sql ="select * from emp ";
        List<Emp> query = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : query) {
            System.out.println(emp);
        }
    }

    /**
     * RowMapper查询
     */
    @Test
    public void test6_1(){
        String sql ="select * from emp";
        List<Emp> query = template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                Emp emp = new Emp();
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");

                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setSalary(salary);
                emp.setJoindate(joindate);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);
                return emp;
            };
        });
        for (Emp emp : query) {
            System.out.println(emp);
        }

    }

    /**
     * 计数
     */
    @Test
    public void test7(){
        String sql ="select count(id) from emp";
        Integer integer = template.queryForObject(sql, Integer.class);
        System.out.println(integer);
    }

    /**
     * 查询单个对象
     */
    @Test
    public void test8(){
        String sql="select * from emp where ename= ?";
        Emp emp = template.queryForObject(sql, new BeanPropertyRowMapper<Emp>(Emp.class),"林冲");
        System.out.println(emp);
    }

}
