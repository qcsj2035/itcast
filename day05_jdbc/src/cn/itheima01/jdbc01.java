package cn.itheima01;/*
 *
 *2019/12/14 0014
 *
 */

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import javax.xml.transform.Source;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class jdbc01
{
    public static void main(String[] args) throws Exception {
        //3.1定义properties
        Properties prop =new Properties();
        //3.2加载配置文件得到输入流对象
        InputStream is = jdbc01.class.getClassLoader().getResourceAsStream("druid.properties");
        prop.load(is);
        DataSource ds = DruidDataSourceFactory.createDataSource(prop);

        Connection con = ds.getConnection();
        System.out.println(con);



    }

}
