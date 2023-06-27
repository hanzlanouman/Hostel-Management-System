package com.hms.hms_dashboard_01.controllers;

import com.hms.hms_dashboard_01.DTO.IncidentDTO;
import com.hms.hms_dashboard_01.dal.DALIncidentManager;
import com.hms.hms_dashboard_01.model.entities.Incident;

import java.util.List;

public class IncidentController {

    public static void addIncident(IncidentDTO incident) {
        DALIncidentManager.addIncident(incident);
    }
    public static void deleteIncident(int incidentId) {
        DALIncidentManager.deleteIncident(incidentId);
    }

    public static List<Incident> getAllIncidents(){
        return DALIncidentManager.getAllIncidents();
    }
}
