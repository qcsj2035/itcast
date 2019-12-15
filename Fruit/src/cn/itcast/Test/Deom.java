package cn.itcast.Test;/*
 *
 *2019/12/15 0015
 *
 */

import cn.itcast.Uitls.JDBCUtils;
import cn.itcast.domain.Fruit;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public  class Deom {
    static Scanner sc =new Scanner(System.in);
    public static JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());
    public static void main(String[] args) {
        show();
    }
    public static void show()  {

        while (true){
            System.out.println("==========欢迎来到水果超市信息管理==========");
            System.out.println("请输入您的选择："+"(1.查看水果\t2.添加水果\t3.修改水果\t4.删除水果\t5.退出)");
            String type = sc.next();
            switch (type){
                case "1":
                    //查看所有水果
                     select();
                    break;
                case "2":
                   //添加水果
                    insert();
                    break;
                case "3":
                    //修改水果
                    updete();
                    break;
                case "4":
                    //删除水果
                    delete();
                    break;
                case "5":
                    //根据name模糊查询
                    selectLike();
                    break;
                case "6":
                    //分页
                    limit();
                    break;
                case "7":
                    System.out.println("拜拜~~~☺☺☺");
                    System.exit(0);//JVM退出
                    break;
            }

        }
    }
    public static void insert(){
        System.out.println("请输入水果id");
        String id = sc.next();
        System.out.println("请输入水果名称");
        String name = sc.next();
        System.out.println("请输入水果价格");
        String price = sc.next();
        System.out.println("请输入水果重量");
        String weight = sc.next();
        System.out.println("请输入水果生源地");
        String address = sc.next();
        String sql="insert into fruit values(?,?,?,?,?)";
        int insert = template.update(sql, id, name, price, weight, address);
        if (insert>0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }
    public static void delete(){
        System.out.println("请输入要删除的id");
        String id = sc.nextLine();
        String sql="delete from fruit where id=?";
        int delete = template.update(sql, id);
        if (delete>0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }

    }
    public static void updete(){
        System.out.println("请根据id修改您的需求");
        String id = sc.nextLine();
        System.out.println("请输入新的名称");
        String name = sc.nextLine();
        System.out.println("请输入新的价格");
        String price = sc.nextLine();
        System.out.println("请输入新的重量");
        String weight = sc.nextLine();
        System.out.println("请输入新的生源地");
        String address = sc.nextLine();
        String sql="update friut set name=?,price=?,weight=?,address=? where id=?";
        int update = template.update(sql, name, price, weight, address, id);
        if (update>0){
            System.out.println("修改成功");
        }else {
            System.out.println("数据没有变更或者修改失败");
        }
    }
    public static void select(){
        String sql="select * from fruit ";
        List<Fruit> query = template.query(sql, new BeanPropertyRowMapper<Fruit>(Fruit.class));
        for (Fruit fruit : query) {
            System.out.println(fruit);
        }
    }
    public static void selectLike(){
        System.out.println("模糊查询");
        String name = sc.nextLine();
        String sql="select * from fruit where name like \"%"+name+"%\"";
        List<Fruit> query = template.query(sql, new BeanPropertyRowMapper<Fruit>(Fruit.class));
        for (Fruit fruit : query) {
            System.out.println(fruit);
        }
    }
    public static void limit(){
        System.out.println("请选择每页条数");
        String index1 = sc.nextLine();
        System.out.println("请选择当前的页码");
        String index2 = sc.nextLine();
        String sql ="select * from fruit limit ?,?";
        List<Fruit> query = template.query(sql, new BeanPropertyRowMapper<Fruit>(Fruit.class), index1, index2);
        for (Fruit fruit : query) {
            System.out.println(fruit);
        }
    }

}
