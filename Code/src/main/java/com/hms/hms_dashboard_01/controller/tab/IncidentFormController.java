package com.hms.hms_dashboard_01.controller.tab;
import com.hms.hms_dashboard_01.DTO.IncidentDTO;
import com.hms.hms_dashboard_01.Validators.IncidentFormValidator;
import com.hms.hms_dashboard_01.Factory.HMSFactory;
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
    public void addIncident(ActionEvent e){

        IncidentDTO Incident = HMSFactory.getInstanceOfIncident();

        if(Objects.equals(IncidentId.getText(), ""))
        {
            Incident.setIncidentId(0);
        } else
        {
            Incident.setIncidentId(Integer.parseInt(IncidentId.getText()));
        }
        Incident.setDay(Day.getText());
        Incident.setDate(Date.getText());
        Incident.setDescription(Description.getText());
        Incident.setLocation(Location.getText());
        Incident.setTime(Time.getText());


        if (!IncidentFormValidator.isValidInfo(Incident)){
//            Pop an alert saying invalid info
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Information");
            alert.setHeaderText("Invalid Information");
            alert.setContentText("Please enter valid information");
            alert.showAndWait();

        }

        else
        {
            DALIncidentManager.addIncident(Incident);
            Stage stage = (Stage) IncidentId.getScene().getWindow();
            stage.close();
        }

    }
}
