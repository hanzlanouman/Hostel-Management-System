package com.hms.hms_dashboard_01.dal;
import com.hms.hms_dashboard_01.DTO.IncidentDTO;

import java.sql.*;
public class DALIncidentManager {

    static Connection conn = DatabaseConnection.getConnection();
    static int incidentId = 0;

    public static void addIncident(IncidentDTO incident) {
        try {
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO Incidents ( incidentid, inc_date, day, location, description, incidenttime ) " +
                    "VALUES ( " + incidentId + ", '" + incident.getDate() + "', '" + incident.getDay() + "', '" + incident.getLocation() + "', '" + incident.getDescription() + "', '" + incident.getTime() + "' )";

            stmt.executeUpdate(query);

            System.out.println("Data has been inserted into Incidents table.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}