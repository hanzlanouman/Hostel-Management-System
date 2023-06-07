package com.hms.hms_dashboard_01.controller.tab;

import com.hms.hms_dashboard_01.model.entities.Warden;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class WardensController implements Initializable {


    @FXML
    private TableColumn<Warden, String> wardenContact;

    @FXML
    private TableColumn<Warden, String> wardenEmail;

    @FXML
    private TableColumn<Warden, Integer> wardenId;

    @FXML
    private TableColumn<Warden, String> wardenName;

    @FXML
    private TableView<Warden> wardenTable;

    ObservableList<Warden> wardenList = FXCollections.observableArrayList(
            new Warden("Ahmed", "ahmed@email.com", "123456789", 1),
            new Warden("Ali", "ali@email.com", "123456789", 2)
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        wardenName.setCellValueFactory(new PropertyValueFactory<>("wardenName"));
        wardenId.setCellValueFactory(new PropertyValueFactory<>("wardenId"));
        wardenContact.setCellValueFactory(new PropertyValueFactory<>("wardenContact"));
        wardenEmail.setCellValueFactory(new PropertyValueFactory<>("wardenEmail"));

        wardenTable.setItems(wardenList);




    }

    public void deleteWarden(ActionEvent e){
        Alert deleteRoomAlert = new Alert(Alert.AlertType.CONFIRMATION);
        deleteRoomAlert.setTitle("Delete Room");
        deleteRoomAlert.setHeaderText("Are you sure you want to delete this warden?");
        if (deleteRoomAlert.showAndWait().get().equals(ButtonType.CANCEL)) {
            return;
        }
        wardenTable.getItems().removeAll(wardenTable.getSelectionModel().getSelectedItem());



    }
}
