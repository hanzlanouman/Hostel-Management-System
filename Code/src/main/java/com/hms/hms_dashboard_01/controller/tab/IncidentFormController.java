package com.hms.hms_dashboard_01.controller.tab;
import com.hms.hms_dashboard_01.DTO.IncidentDTO;
import com.hms.hms_dashboard_01.Validators.IncidentFormValidator;
import com.hms.hms_dashboard_01.Factory.HMSFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class IncidentFormController {

    @FXML
    private TextField Date;
    @FXML
    private TextField Day;
    @FXML
    private TextField Location;
    @FXML
    private TextField Time;
    @FXML
    private TextField Description;


    public void addIncident(ActionEvent e){
        boolean isValid = IncidentFormValidator.validateFields(Date, Day, Location, Time, Description);
        if (isValid) {
            IncidentDTO Incident = HMSFactory.getInstanceOfIncident();
            Incident.setDay(String.join(Day.getText()));
            Incident.setDate(String.join(Date.getText()));
            Incident.setLocation(String.join(Location.getText()));
            Incident.setTime(String.join(Time.getText()));
            Incident.setDescription(String.join(Description.getText()));

            System.out.println(Incident.getDay());
            System.out.println(Incident.getDate());
            System.out.println(Incident.getLocation());
            System.out.println(Incident.getTime());
            System.out.println(Incident.getDescription());
        }
    }
}
