package com.hms.hms_dashboard_01.controller.tab;

import com.hms.hms_dashboard_01.model.entities.Staff;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class StaffController implements Initializable {
    @FXML
    private TableColumn<Staff, String> staffContact;

    @FXML
    private TableColumn<Staff, String> staffEmail;

    @FXML
    private TableColumn<Staff, Integer> staffId;

    @FXML
    private TableColumn<Staff, String> staffName;

    @FXML
    private TableColumn<Staff, String> staffRole;

    @FXML
    private TableView<Staff> staffTable;

    ObservableList<Staff> studentList = FXCollections.observableArrayList(
            new Staff(1,"Ali", "Cook", "123456789", "ali@email.com"),
            new Staff(2,"Ahmed", "Security", "123456789", "ahmed@email.com")

    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        staffId.setCellValueFactory(new PropertyValueFactory<>("staffId"));
        staffName.setCellValueFactory(new PropertyValueFactory<>("staffName"));
        staffContact.setCellValueFactory(new PropertyValueFactory<>("staffContact"));
        staffEmail.setCellValueFactory(new PropertyValueFactory<>("staffEmail"));
        staffRole.setCellValueFactory(new PropertyValueFactory<>("staffRole"));


        staffTable.setItems(studentList);




    }
}
