package com.hms.hms_dashboard_01.dal;

import com.hms.hms_dashboard_01.DTO.MenuDTO;

import java.sql.*;

public class DALMenuManager {

    static Connection conn = DatabaseConnection.getConnection();

    public static void addMenu(MenuDTO menu) {
        try {
            String query = "INSERT INTO Menus (Breakfast, Lunch, Dinner, Day) VALUES (?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, menu.getBreakfast());
            pstmt.setString(2, menu.getLunch());
            pstmt.setString(3, menu.getDinner());
            pstmt.setString(4, menu.getDay());

            pstmt.executeUpdate();

            System.out.println("Data has been inserted into Menus table.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
