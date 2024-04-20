/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.suicehehe.demojdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author suice
 */
public class Demo {
        public static void main(String[] args) {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection conn = connectJDBC.connect();

        Demo demo = new Demo();
        
        // 1. list
        demo.list(conn);
        
        // 2. insert
        // demo.insert(conn, 3, "lemon", "160");
        // demo.list(conn);
        // 3. update 
        // demo.update(conn, 3, "170");
        // demo.list(conn);
        // 4. delete
        // demo.delete(conn, 3);
        // demo.list(conn);
        // Close
    }
    
    public void list(Connection conn) {
        if (conn != null) {
            String query = "SELECT * FROM dbo.Inventory;";

            Statement stm = null;
            try {
                
                stm = conn.createStatement();

                
                ResultSet rs = stm.executeQuery(query);

                
                System.out.println("Result set size: " + rs.getFetchSize());

               
                while (rs.next()) {  
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String quantity = rs.getString("quantity");
                    
                    System.out.println(id + " - " + name + " - " + quantity);
                }
                
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("FAIL1!" + e.getMessage());
            }
        } else {
            System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
        }
    }
    
    public void insert(Connection conn, int id, String name, String quantity) {
        if (conn != null) {
            String query = "INSERT INTO dbo.Inventory(id, name, quantity) VALUES (?, ?, ?)";

            PreparedStatement pstm = null;
        try {
                pstm = conn.prepareStatement(query);

                pstm.setInt(1, id);
                pstm.setString(2, name);
                pstm.setString(3, quantity);
                
                int row = pstm.executeUpdate();
                if(row != 0){
                    System.out.println("Thêm thành công " + row);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("FAIL2!" + e.getMessage());
            } 
        } else {
            System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
        }
    }
    
    public void update(Connection conn, int id, String quantity) {
        if (conn != null) {
            String query = "UPDATE dbo.Inventory SET quantity = ? WHERE id = ?";

            PreparedStatement pstm = null;
        try {
                pstm = conn.prepareStatement(query);

                pstm.setString(1, quantity);
                pstm.setInt(2, id);
                
                int row = pstm.executeUpdate();
                if(row != 0){
                    System.out.println("Cập nhật thành công " + row);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("FAIL3!" + e.getMessage());
            } 
        } else {
            System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
        }
    }
    
    public void delete(Connection conn, int id) {
        if (conn != null) {
            String query = "DELETE FROM dbo.Inventory WHERE id = ?";

            PreparedStatement pstm = null;
        try {
                pstm = conn.prepareStatement(query);

                pstm.setInt(1, id);
                
                int row = pstm.executeUpdate();
                if(row != 0){
                    System.out.println("Xóa thành công " + row);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("FAIL4!" + e.getMessage());
            } 
        } else {
            System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
        }
    }
}