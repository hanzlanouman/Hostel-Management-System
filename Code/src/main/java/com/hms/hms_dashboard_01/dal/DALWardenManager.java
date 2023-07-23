package com.hms.hms_dashboard_01.dal;
import com.hms.hms_dashboard_01.DTO.WardenDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DALWardenManager {

    private static Connection conn = DatabaseConnection.getConnection();

    public static String addWarden(WardenDTO warden) {
        boolean alreadyExists = false;

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Wardens WHERE WardenId = " + warden.getWardenId());

            while (rs.next()) {
                alreadyExists = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        if (alreadyExists) {
            return "Warden already exists";
        } else {
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


                return "success";
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
        return "success";
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

    public static void deleteWarden(int id){

        try {
            Statement stmt = conn.createStatement();
            String query = "DELETE FROM Wardens WHERE WardenId = " + id;

            stmt.executeUpdate(query);

            System.out.println("Data has been deleted from Wardens table.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
