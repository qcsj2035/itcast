package cn.SpringJDBC;/*
 *
 *2019/12/14 0014
 *
 */

import cn.JDBCUtils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class template01 {
    public static void main(String[] args) {
        //1.创建JDBCtemplate对象
//        JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());
//        String sql="select * from account where id =?";
//        int count = template.update("update account set balance=? where id=?",5000,3);
//        System.out.println(count);
//        JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());
//        String sql ="insert into account values(null,?,?)";
//        int count = template.update(sql, "刘思", 6000);
//        System.out.println(count);
        JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());
        String sql ="delete from account where id=?";
        int count = template.update(sql, 7);
        System.out.println(count);

    }


}
