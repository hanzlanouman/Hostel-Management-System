package com.hms.hms_dashboard_01.dal;
import com.hms.hms_dashboard_01.DTO.WardenDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DALWardenManager {

    private static Connection conn = DatabaseConnection.getConnection();

    public static void addWarden(WardenDTO warden) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Wardens (WardenId, WardenName, WardenEmail, WardenContact, Gender, Address) " +
                    "VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, warden.getWardenId());
            stmt.setString(2, warden.getWardenName());
            stmt.setString(3, warden.getWardenEmail());
            stmt.setString(4, warden.getWardenContact());
            stmt.setString(5, warden.getGender());
            stmt.setString(6, warden.getAddress());

            stmt.executeUpdate();

            System.out.println("Data has been inserted into Wardens table.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<WardenDTO> getAllWardens() {
        List<WardenDTO> wardens = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Wardens");

            while (rs.next()) {
                WardenDTO warden = new WardenDTO();
                warden.setWardenId(rs.getInt("WardenId"));
                warden.setWardenName(rs.getString("WardenName"));
                warden.setWardenEmail(rs.getString("WardenEmail"));
                warden.setWardenContact(rs.getString("WardenContact"));
                warden.setGender(rs.getString("Gender"));
                warden.setAddress(rs.getString("Address"));

                wardens.add(warden);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return wardens;
    }
}
