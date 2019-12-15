package cn.itcast.Uitls;/*
 *
 *2019/12/15 0015
 *
 */

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource ds;

    static {
        Properties prop =new Properties();
        try {
            prop.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    public static  void close(Statement pstmt,Connection con){

        close(null,pstmt ,con );
    }
    public static  void close(ResultSet rs,Statement pstmt,Connection con){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
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
    public static DataSource getDataSource(){
        return ds;
    }

}
