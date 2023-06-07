package com.hms.hms_dashboard_01.model.entities;

public class Incident {

    int incidentId;
    String incidentName;
    int incidentTime;

    public Incident(int incidentId, String incidentName, int incidentTime) {
        this.incidentId = incidentId;
        this.incidentName = incidentName;
        this.incidentTime = incidentTime;
    }

    public int getIncidentId() {
        return incidentId;
    }
    public String getIncidentName() {
        return incidentName;
    }
    public int getIncidentTime(){
        return incidentTime;
    }
}
