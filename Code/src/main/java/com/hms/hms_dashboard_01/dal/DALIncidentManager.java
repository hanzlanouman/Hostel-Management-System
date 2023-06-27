package com.hms.hms_dashboard_01.dal;
import com.hms.hms_dashboard_01.DTO.IncidentDTO;
import com.hms.hms_dashboard_01.model.entities.Incident;
import com.hms.hms_dashboard_01.model.entities.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DALIncidentManager {

    static Connection conn = DatabaseConnection.getConnection();


    public static void addIncident(IncidentDTO incident) {
        try {
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO Incidents ( incidentid, inc_date, day, location, description, incidenttime ) " +
                    "VALUES ( " + incident.getIncidentId() + ", '" + incident.getDate() + "', '" + incident.getDay() + "', '" + incident.getLocation() + "', '" + incident.getDescription() + "', '" + incident.getTime() + "' )";

            stmt.executeUpdate(query);

            System.out.println("Data has been inserted into Incidents table.");
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

    public static void deleteIncident(int incidentId) {
        try {
            Statement stmt = conn.createStatement();
            String query = "DELETE FROM Incidents WHERE incidentid = " + incidentId;

            stmt.executeUpdate(query);

            System.out.println("Data has been deleted from Incidents table.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}