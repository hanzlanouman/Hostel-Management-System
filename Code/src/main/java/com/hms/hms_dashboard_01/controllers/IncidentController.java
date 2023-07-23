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
            DALIncidentManager dalIncidentManager = HMSFactory.getInstanceOfIncidentManager();
           return dalIncidentManager.addIncident(incident);
        }else {
            return validationError;
        }


//        DALIncidentManager.addIncident(incident);

    }
    public  void deleteIncident(int incidentId) {

        DALIncidentManager dalIncidentManager = HMSFactory.getInstanceOfIncidentManager();
        dalIncidentManager.deleteIncident(incidentId);
    }

    public  List<Incident> getAllIncidents(){
        DALIncidentManager dalIncidentManager = HMSFactory.getInstanceOfIncidentManager();
         return dalIncidentManager.getAllIncidents();
    }
}
