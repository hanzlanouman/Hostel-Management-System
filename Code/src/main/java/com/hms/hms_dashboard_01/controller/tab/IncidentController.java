package com.hms.hms_dashboard_01.controller.tab;

import com.hms.hms_dashboard_01.model.entities.Incident;
import com.hms.hms_dashboard_01.model.entities.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class IncidentController implements Initializable {
    @FXML
    private TableView<Incident> incidentTable;
    @FXML
    private Button resolveIncident;

    @FXML
    private TableColumn<Incident, String> incidentId;

    @FXML
    private TableColumn<Incident, Integer> incidentName;

    @FXML
    private TableColumn<Incident, String> incidentTime;

    ObservableList<Incident> incidentList = FXCollections.observableArrayList(
            new Incident(1, "Incident", 123),
            new Incident(2, "Incident", 123),
            new Incident(3, "Incident", 123),
            new Incident(4, "Incident", 123)
            );

    public void resolveIncident(ActionEvent actionEvent) {
        Alert deleteRoomAlert = new Alert(Alert.AlertType.CONFIRMATION);
        deleteRoomAlert.setTitle("Delete Room");
        deleteRoomAlert.setHeaderText("Are you sure you want to delete this room?");
        if (deleteRoomAlert.showAndWait().get().equals(ButtonType.CANCEL)) {
            return;
        }
        incidentTable.getItems().removeAll(incidentTable.getSelectionModel().getSelectedItem());
    }
    public void initialize(URL url, ResourceBundle resourceBundle) {
        incidentId.setCellValueFactory(new PropertyValueFactory<>("incidentId"));
        incidentName.setCellValueFactory(new PropertyValueFactory<>("incidentName"));
        incidentTime.setCellValueFactory(new PropertyValueFactory<>("incidentTime"));
        incidentTable.setItems(incidentList);
    }
}
