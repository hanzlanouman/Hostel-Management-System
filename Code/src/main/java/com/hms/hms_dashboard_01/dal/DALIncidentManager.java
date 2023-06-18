package com.hms.hms_dashboard_01.dal;
import com.hms.hms_dashboard_01.DTO.IncidentDTO;

import java.sql.*;
public class DALIncidentManager {

    static Connection conn = DatabaseConnection.getConnection();
    static int incidentId = 0;

    public static void addIncident(IncidentDTO incident) {
        try {
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO Incidents (IncidentId, INC_DATE, Day, Location, Description, INCIDENTTIME) " +
                    "VALUES (2, null, '" +
                    incident.getDay() + "', '" + incident.getLocation() + "', '" + incident.getDescription() + "', '" +
                    incident.getTime() + "')";

            stmt.executeUpdate(query);

            System.out.println("Data has been inserted into Incidents table.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}