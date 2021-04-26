/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restisdcm.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author class to manage database connection with singleton pattern
 */
public class DataSource {
    private static DataSource instance = null;
    private String url;
    private String jdbcDriver;
    private String user;
    private String password;
    private Connection con;

    public DataSource() {
        this.user = "mydb";
        this.password = "mydb";
        this.url = "jdbc:derby://localhost:1527/mydb";
        this.jdbcDriver = "com.mysql.cj.jdbc.Driver";
    }
    
    public static DataSource getInstance(){
            if(instance == null)
                    instance = new DataSource();
            return instance;
    }
    
    public Connection getConnection(){
        Connection conn = null;

        try {
                Class.forName(getJdbcDriver()).newInstance();
                conn = DriverManager.getConnection(getUrl(), getUser(), getPassword());
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
                e.printStackTrace();
        }

        return conn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
}
