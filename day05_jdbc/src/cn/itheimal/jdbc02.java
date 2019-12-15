package cn.itheimal;/*
 *
 *2019/12/14 0014
 *
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.IdentityHashMap;

public class jdbc02 {
    public static void main(String[] args) throws SQLException {
//        DataSource ds =new ComboPooledDataSource();
//        for (int i = 1; i <=11 ; i++) {
//            Connection con = ds.getConnection();
//            System.out.println(i+" "+con);
//            if (i==5){
//                con.close();
//            }
//        }
            new jdbc02().getAll();
    }
    public void getAll() throws SQLException {
        DataSource ds =new ComboPooledDataSource("otherc3p0");
        for (int i = 1; i <=9 ; i++) {
            Connection con = ds.getConnection();
            System.out.println(i+" "+con);

            if (i==5){
                con.close();
            }
        }
    }


}
