package cn.itcast.domain;/*
 *
 *2019/12/15 0015
 *
 */

public class Manager {
    private String usename;
    private String password;

    public Manager(String usename, String password) {
        this.usename = usename;
        this.password = password;
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "usename='" + usename + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
