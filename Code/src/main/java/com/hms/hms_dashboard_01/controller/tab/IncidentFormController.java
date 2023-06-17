package com.hms.hms_dashboard_01.controller.tab;
import com.hms.hms_dashboard_01.DTO.IncidentDTO;
import com.hms.hms_dashboard_01.Validators.IncidentFormValidator;
import com.hms.hms_dashboard_01.Factory.HMSFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
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
    private TextArea Description;

    public void addIncident(ActionEvent e){



            IncidentDTO Incident = HMSFactory.getInstanceOfIncident();
            Incident.setDay(String.join(Day.getText()));
            Incident.setDate(String.join(Date.getText()));
            Incident.setDescription(String.join(Description.getText()));
            Incident.setLocation(String.join(Location.getText()));
            Incident.setTime(String.join(Time.getText()));
            //Response
            //use database to insert the fields into the database
            //Make one validator to validate all the fields for Forms
//
            if (!IncidentFormValidator.isValidInfo(Incident)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Information");
                alert.setHeaderText("Invalid Information");
                alert.setContentText("Please enter valid information");
                alert.showAndWait();
            }
    }
}
