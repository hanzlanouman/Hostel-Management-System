package com.hms.hms_dashboard_01.ui.tab;

import com.hms.hms_dashboard_01.Factory.HMSFactory;
import com.hms.hms_dashboard_01.controllers.WardenController;
import com.hms.hms_dashboard_01.dal.DALWardenManager;
import com.hms.hms_dashboard_01.DTO.WardenDTO;
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
import java.util.ResourceBundle;

public class WardensTabController implements Initializable {

    @FXML
    private TableColumn<WardenDTO, String> wardenContact;
    @FXML
    private TableColumn<WardenDTO, String> wardenEmail;
    @FXML
    private TableColumn<WardenDTO, Integer> wardenId;

    @FXML
    private TableColumn<WardenDTO, String> wardenName;

    @FXML
    private TableView<WardenDTO> wardenTable;
    ObservableList<WardenDTO> wardenList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        wardenName.setCellValueFactory(new PropertyValueFactory<>("wardenName"));
        wardenId.setCellValueFactory(new PropertyValueFactory<>("wardenId"));
        wardenContact.setCellValueFactory(new PropertyValueFactory<>("wardenContact"));
        wardenEmail.setCellValueFactory(new PropertyValueFactory<>("wardenEmail"));
        WardenController wardenController = HMSFactory.getInstanceOfWardenController();
        wardenList = FXCollections.observableArrayList(wardenController.getAllWardens());
        wardenTable.setItems(wardenList);
    }

    public void addWarden(ActionEvent e) throws IOException {
        Stage stage = new Stage();
        Parent root1 = FXMLLoader.load(getClass().getResource(path.getPath("tab", "add_warden_form")));
        stage.setTitle("Add Warden");
        stage.setScene(new Scene(root1, 1054, 650));
        stage.show();
    }

    public void deleteWarden(ActionEvent e) {
        WardenDTO warden = wardenTable.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Warden");
        alert.setHeaderText("Are you sure you want to delete this warden?");
        alert.setContentText("Warden Name: " + warden.getWardenName() + "\nWarden ID: " + warden.getWardenId());
        alert.showAndWait();

        if(alert.getResult().getText().equals("OK")){
            WardenController wardenController = HMSFactory.getInstanceOfWardenController();
            wardenController.deleteWarden(warden.getWardenId());
            wardenTable.getItems().remove(warden);
        }
    }
}
