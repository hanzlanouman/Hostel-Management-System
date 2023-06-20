package com.hms.hms_dashboard_01.controller.tab;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
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

    ObservableList<Incident> IncidentList = FXCollections.observableArrayList(

            new Incident(1, "2023-09-07","Monday", "Laundary", "A girl got Slipped.", "4.00 PM"),
            new Incident(2, "2023-09-07","Monday", "Laundary", "A girl got Slipped.", "4.00 PM"),
            new Incident(3, "2023-09-07","Monday", "Laundary", "A girl got Slipped.", "4.00 PM")
);
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
        Parent root1 = FXMLLoader.load(getClass().getResource(path.getPath("tab", "IncidentTab_Add")));
        stage.setTitle("Add Incident");
        stage.setScene(new Scene(root1, 1054, 650));
        stage.show();
    }
}
