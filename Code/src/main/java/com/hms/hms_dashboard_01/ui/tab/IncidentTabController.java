package com.hms.hms_dashboard_01.ui.tab;

import com.hms.hms_dashboard_01.Factory.HMSFactory;
import com.hms.hms_dashboard_01.controllers.IncidentController;
import com.hms.hms_dashboard_01.model.entities.Incident;
import com.hms.hms_dashboard_01.utility.path;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class IncidentTabController implements Initializable {

    @FXML
    private TableColumn<Incident, Integer> IncidentId;
    @FXML
    private TableColumn<Incident, String> Day;

    @FXML
    private TableColumn<Incident, String> Date;

    @FXML
    private TableColumn<Incident, Integer> Time;

    @FXML
    private TableColumn<Incident, String> Location;

    @FXML
    private TableColumn<Incident, String> Description;

    @FXML
    private TableView<Incident> IncidentTable;

    ObservableList<Incident> IncidentList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        IncidentController incidentController = HMSFactory.getInstanceOfIncidentController();
        IncidentList = FXCollections.observableArrayList(Objects.requireNonNull(incidentController.getAllIncidents()));
        loadTable(IncidentList);
    }

    public void loadTable(ObservableList<Incident> IncidentList){
        IncidentId.setCellValueFactory(new PropertyValueFactory<>("IncidentId"));
        Day.setCellValueFactory(new PropertyValueFactory<>("Day"));
        Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
        Time.setCellValueFactory(new PropertyValueFactory<>("Time"));
        Location.setCellValueFactory(new PropertyValueFactory<>("Location"));
        Description.setCellValueFactory(new PropertyValueFactory<>("Description"));
        IncidentTable.setItems(IncidentList);
    }

    public void addIncident(ActionEvent e) throws IOException {
//       set the stage scene to add Incident
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader( getClass().getResource(path.getPath("tab", "IncidentTab_Add")));
        Parent root1 = loader.load();
        IncidentFormController incidentFormController = loader.getController();
        incidentFormController.setIncidentController(this);
        stage.setTitle("Add Incident");
        stage.setScene(new Scene(root1, 1054, 650));
        stage.show();
    }

    public void updateIncidentTable(){
        IncidentList.clear();
        IncidentController incidentController = HMSFactory.getInstanceOfIncidentController();
        IncidentList.addAll(Objects.requireNonNull(incidentController.getAllIncidents()));

    }

    public void resolveIncident(ActionEvent e) throws IOException {
//        Delete the selected incident from the database
        Incident incident = IncidentTable.getSelectionModel().getSelectedItem();
        if(incident == null){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No Incident Selected");
            alert.setContentText("Please select an incident to resolve");
            alert.showAndWait();

            return;
        }else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm");
            alert.setHeaderText("Confirm Incident Resolution");
            alert.setContentText("Are you sure you want to resolve this incident?");
            alert.showAndWait();
            if(alert.getResult().getText().equals("OK")){
                IncidentController incidentController = HMSFactory.getInstanceOfIncidentController();
                incidentController.deleteIncident(incident.getIncidentId());
                ObservableList<Incident> IncdentList = FXCollections.observableArrayList();
                updateIncidentTable();
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Success");
                alert1.setHeaderText("Incident Resolved");
                alert1.setContentText("Incident has been resolved");
                alert1.showAndWait();
            }
        }

    }
}
