package com.hms.hms_dashboard_01.dal;
import com.hms.hms_dashboard_01.DTO.WardenDTO;

import java.sql.*;
public class DALWardenManager {

    static Connection conn = DatabaseConnection.getConnection();

    public static void addWarden(WardenDTO warden) {
        try {
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO Wardens (WardenId, WardenName, WardenEmail, WardenContact, Gender, Address) " +
                    "VALUES (" + warden.getWardenId() + ", '" + warden.getWardenName() + "', '" +
                    warden.getWardenEmail() + "', '" + warden.getWardenContact() + "', '" +
                    warden.getGender() + "', '" + warden.getAddress() + "')";

            stmt.executeUpdate(query);

            System.out.println("Data has been inserted into Wardens table.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

