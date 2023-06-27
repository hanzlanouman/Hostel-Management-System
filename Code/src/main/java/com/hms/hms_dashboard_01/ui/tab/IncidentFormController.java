package com.hms.hms_dashboard_01.ui.tab;

import com.hms.hms_dashboard_01.DTO.IncidentDTO;
import com.hms.hms_dashboard_01.Validators.IncidentFormValidator;
import com.hms.hms_dashboard_01.Factory.HMSFactory;
import com.hms.hms_dashboard_01.controllers.IncidentManager;
import com.hms.hms_dashboard_01.dal.DALIncidentManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.Objects;

public class IncidentFormController {

    @FXML
    private TextField IncidentId;

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

    private IncidentController incidentController;

    public void setIncidentController(IncidentController incidentController) {
        this.incidentController = incidentController;
    }

    public void addIncident(ActionEvent e) {
        IncidentDTO incident = HMSFactory.getInstanceOfIncident();

        if (Objects.equals(IncidentId.getText(), "")) {
            incident.setIncidentId(0);
        } else {
            try {
                int id = Integer.parseInt(IncidentId.getText());
                incident.setIncidentId(id);
            } catch (NumberFormatException ex) {
                // Display error message for invalid ID
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Information");
                alert.setHeaderText("Invalid Incident ID");
                alert.setContentText("Please enter a valid numeric value for the Incident ID.");
                alert.showAndWait();
                return; // Stop further processing
            }
        }

        incident.setDay(Day.getText());
        incident.setDate(Date.getText());
        incident.setDescription(Description.getText());
        incident.setLocation(Location.getText());
        incident.setTime(Time.getText());

        String validationError = IncidentFormValidator.validateIncidentDetails(incident);
        if (validationError != null) {
            // Display specific error message based on the validation error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Information");
            alert.setHeaderText("Invalid Information");
            alert.setContentText(validationError);
            alert.showAndWait();
        } else {

            // Show Confirmation alert and close the stage
            IncidentManager.addIncident(incident);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Incident Registered!");
            alert.setContentText("Incident Registered Successfully");
            incidentController.updateIncidentTable();
            alert.showAndWait();
            Stage stage = (Stage) IncidentId.getScene().getWindow();
            stage.close();
        }
    }

}
