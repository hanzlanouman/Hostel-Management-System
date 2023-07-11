package com.hms.hms_dashboard_01.controllers;

import com.hms.hms_dashboard_01.DTO.IncidentDTO;
import com.hms.hms_dashboard_01.Factory.HMSFactory;
import com.hms.hms_dashboard_01.Validators.IncidentFormValidator;
import com.hms.hms_dashboard_01.dal.DALIncidentManager;
import com.hms.hms_dashboard_01.model.entities.Incident;
import javafx.scene.control.Alert;

import java.util.List;
import java.util.Objects;

public class IncidentController {

    public static String addIncident(String id, String Day, String Date, String Description, String Location, String Time) {

        IncidentDTO incident = HMSFactory.getInstanceOfIncident();

        if (Objects.equals(id, "")) {
            incident.setIncidentId(0);
        } else {
            try {
                int stId = Integer.parseInt(id);
                incident.setIncidentId(stId);
            } catch (NumberFormatException ex) {
                // Display error message for invalid ID
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Information");
                alert.setHeaderText("Invalid Incident ID");
                alert.setContentText("Please enter a valid numeric value for the Incident ID.");
                alert.showAndWait();
                return "Please enter a valid numeric value for the Incident ID. i-e 1,2,3";
            }
        }

        incident.setDay(Day);
        incident.setDate(Date);
        incident.setDescription(Description);
        incident.setLocation(Location);
        incident.setTime(Time);

        String validationError = IncidentFormValidator.validateIncidentDetails(incident);

        if(validationError == null){
            DALIncidentManager.addIncident(incident);
            return null;
        }else {
            return validationError;
        }


//        DALIncidentManager.addIncident(incident);

    }
    public static void deleteIncident(int incidentId) {
        DALIncidentManager.deleteIncident(incidentId);
    }

    public static List<Incident> getAllIncidents(){
        return DALIncidentManager.getAllIncidents();
    }
}
