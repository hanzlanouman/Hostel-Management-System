package com.hms.hms_dashboard_01.controller.tab;

import com.hms.hms_dashboard_01.dal.DALIncidentManager;
import com.hms.hms_dashboard_01.dal.DALRoomManager;
import com.hms.hms_dashboard_01.model.entities.Incident;
import com.hms.hms_dashboard_01.model.entities.Room;
import com.hms.hms_dashboard_01.utility.path;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class IncidentController implements Initializable {

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

    ObservableList<Incident> IncidentList = FXCollections.observableArrayList(Objects.requireNonNull(DALIncidentManager.getAllIncidents()));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadTable();
    }

    public void loadTable(){
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
        IncidentList.addAll(DALIncidentManager.getAllIncidents());

    }

    public void resolveIncident(ActionEvent e) throws IOException {
//        Delete the selected incident from the database
        Incident incident = IncidentTable.getSelectionModel().getSelectedItem();
        DALIncidentManager.deleteIncident(incident.getIncidentId());
        updateIncidentTable();
    }
}
