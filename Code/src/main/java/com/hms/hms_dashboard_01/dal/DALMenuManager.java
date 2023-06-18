package com.hms.hms_dashboard_01.dal;

import com.hms.hms_dashboard_01.DTO.MenuDTO;

import java.sql.*;

public class DALMenuManager {

    static Connection conn = DatabaseConnection.getConnection();

    public static void addMenu(MenuDTO menu) {
        try {
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO Menus (MenuId, Day, Breakfast, Lunch, Dinner) " +
                    "VALUES (1, '" + menu.getDay() + "', '" + menu.getBreakfast() + "', '" +
                    menu.getLunch() + "', '" + menu.getDinner() + "')";

            stmt.executeUpdate(query);

            System.out.println("Data has been inserted into Menus table.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
