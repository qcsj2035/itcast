package cn.itheimal;/*
 *
 *2019/12/14 0014
 *
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class jdbc01 {
    public static void main(String[] args) throws SQLException {
        //1.创建数据库连接池对象，接口多态
        DataSource ds =new ComboPooledDataSource();
        //2.获取连接对象
        Connection con = ds.getConnection();
        //3.打印
        System.out.println(con);


    }

}
