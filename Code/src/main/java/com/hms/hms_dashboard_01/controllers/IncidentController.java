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

    public  String addIncident(IncidentDTO incident) {

        String validationError = IncidentFormValidator.validateIncidentDetails(incident);
        if(validationError == null){
           return DALIncidentManager.addIncident(incident);
        }else {
            return validationError;
        }


//        DALIncidentManager.addIncident(incident);

    }
    public  void deleteIncident(int incidentId) {
        DALIncidentManager.deleteIncident(incidentId);
    }

    public  List<Incident> getAllIncidents(){
        return DALIncidentManager.getAllIncidents();
    }
}
