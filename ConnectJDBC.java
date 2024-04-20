/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.suicehehe.demojdbc;

/**
 *
 * @author suice
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJDBC {
    
    static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=TestDB;intergratedSecurity=true;encrypt=true;trustServerCertificate=true;";
    static final String USER = "sa";
    static final String PASS = "Suice.1337@";

    public Connection connect() {
        Connection conn = null;
     
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            System.out.println("Đang kết nối đến cơ sở dữ liệu...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            if (conn != null) {
                System.out.println("Kết nối thành công đến cơ sở dữ liệu!");
            } else {
                System.out.println("Kết nối không thành công.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy JDBC Driver.");
            e.printStackTrace();
        } 
        
        return conn;
    }
}

