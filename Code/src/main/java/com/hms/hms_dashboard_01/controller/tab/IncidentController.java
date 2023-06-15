package com.hms.hms_dashboard_01.controller.tab;

import com.hms.hms_dashboard_01.model.entities.Incident;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class IncidentController implements Initializable {

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
            new Incident("2023-09-07","Monday", "Laundary", "Washing machine malfunction and flooding in the hostel laundry.", "4.00 PM"),
            new Incident("2021-04-23","Sunday", "Mess", "Food poisoning outbreak in the hostel mess.", "3:00 PM")

    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Day.setCellValueFactory(new PropertyValueFactory<>("Day"));
        Date.setCellValueFactory(new PropertyValueFactory<>("Date"));
        Time.setCellValueFactory(new PropertyValueFactory<>("Time"));
        Location.setCellValueFactory(new PropertyValueFactory<>("Location"));
        Description.setCellValueFactory(new PropertyValueFactory<>("Description"));
        IncidentTable.setItems(IncidentList);
    }
}
