package com.hms.hms_dashboard_01.controllers;

import com.hms.hms_dashboard_01.DTO.IncidentDTO;
import com.hms.hms_dashboard_01.dal.DALIncidentManager;

public class IncidentManager {

    public static void addIncident(IncidentDTO incident) {
        DALIncidentManager.addIncident(incident);
    }
    public static void deleteIncident(int incidentId) {
        DALIncidentManager.deleteIncident(incidentId);
    }
}
