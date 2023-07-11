package com.hms.hms_dashboard_01.ui.tab;

import com.hms.hms_dashboard_01.DTO.IncidentDTO;
import com.hms.hms_dashboard_01.Validators.IncidentFormValidator;
import com.hms.hms_dashboard_01.Factory.HMSFactory;
import com.hms.hms_dashboard_01.controllers.IncidentController;
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

    private IncidentTabController incidentTabController;

    public void setIncidentController(IncidentTabController incidentTabController) {
        this.incidentTabController = incidentTabController;
    }

    public void addIncident(ActionEvent e) {

        String validationError = IncidentController.addIncident(IncidentId.getText(), Day.getText(), Date.getText(), Time.getText(), Location.getText(), Description.getText());

        if (validationError != null) {
            // Display specific error message based on the validation error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Information");
            alert.setHeaderText("Invalid Information");
            alert.setContentText(validationError);
            alert.showAndWait();
        } else {

            // Show Confirmation alert and close the stage
//            IncidentController.addIncident(incident);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Incident Registered!");
            alert.setContentText("Incident Registered Successfully");
            incidentTabController.updateIncidentTable();
            alert.showAndWait();
            Stage stage = (Stage) IncidentId.getScene().getWindow();
            stage.close();
        }
    }

}
