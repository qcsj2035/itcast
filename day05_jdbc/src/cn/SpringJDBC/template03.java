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

import java.util.List;
import java.util.Map;

public class template03 {

    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());
    @Test
    public void Test1(){
        String sql ="select * from emp";
        List<Emp> query = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : query) {
            System.out.println(emp);
        }
    }
    @Test
    public void Test2(){
        String sql ="select * from emp where id= ? or ename =? ";
        Map<String, Object> stringObjectMap = template.queryForMap(sql,4,"林冲");
        System.out.println(stringObjectMap);
    }
    @Test
    public void Test3(){
      String sql ="select * from emp ";
        List<Map<String, Object>> maps = template.queryForList(sql);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }
    @Test
    public void Test4(){
        String sql ="select count(id) from emp ";
        Integer integer = template.queryForObject(sql, Integer.class);
        System.out.println(integer);
    }
    @Test
    public void Test5(){
        String sql ="select * from emp where ename= ?";
        Emp emp = template.queryForObject(sql, new BeanPropertyRowMapper<Emp>(Emp.class), "林冲");
        System.out.println(emp);
    }

}
