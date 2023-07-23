package com.hms.hms_dashboard_01.dal;
import com.hms.hms_dashboard_01.DTO.IncidentDTO;
import com.hms.hms_dashboard_01.model.entities.Incident;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DALIncidentManager {

    static Connection conn = DatabaseConnection.getConnection();
    public static String addIncident(IncidentDTO incident) {
      boolean alreadyExists = false;

        try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Incidents WHERE incidentid = " + incident.getIncidentId());

                while (rs.next()) {
                    alreadyExists = true;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            if (alreadyExists) {
                    return "Incident already exists";
            } else {
                try {
                    String query = "INSERT INTO Incidents (incidentid, inc_date, day, location, description, incidenttime) VALUES (?, ?, ?, ?, ?, ?)";

                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setInt(1, incident.getIncidentId());
                    pstmt.setString(2, incident.getDate());
                    pstmt.setString(3, incident.getDay());
                    pstmt.setString(4, incident.getLocation());
                    pstmt.setString(5, incident.getDescription());
                    pstmt.setString(6, incident.getTime());

                    pstmt.executeUpdate();
    return "success";
                    //System.out.println("Data has been inserted into Incidents table.");
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        return "success";

    }

    // ...

    public static void deleteIncident(int incidentId) {
        try {
            String query = "DELETE FROM Incidents WHERE incidentid = ?";

            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, incidentId);

            pstmt.executeUpdate();

            System.out.println("Data has been deleted from Incidents table.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static List<Incident> getAllIncidents(){
        List<Incident> incidents = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Incidents");
            while (rs.next()) {
                Incident incident = new Incident();

                incident.setIncidentId(rs.getInt("incidentid"));
                incident.setDate(rs.getString("inc_date"));
                incident.setDay(rs.getString("day"));
                incident.setLocation(rs.getString("location"));
                incident.setDescription(rs.getString("description"));
                incident.setTime(rs.getString("incidenttime"));

                incidents.add(incident);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return incidents;
    }


}