package cn.itheima0;/*
 *
 *2019/12/13 0013
 *
 */

import com.mysql.jdbc.Driver;

import java.sql.DriverManager;
import java.sql.SQLException;

public class StaticJdbc {
    static {
        try {
            System.out.println("开始");
            DriverManager.registerDriver(new Driver());
            System.out.println("结束");
        } catch (SQLException var1) {
            throw new RuntimeException("Can't register driver!");
        }
    }

}
