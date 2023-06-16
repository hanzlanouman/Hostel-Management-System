package com.hms.hms_dashboard_01.controller.tab;

import com.hms.hms_dashboard_01.model.entities.Warden;
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

    public void addWarden(ActionEvent e) throws IOException {
        Stage stage = new Stage();
        Parent root1 = FXMLLoader.load(getClass().getResource(path.getPath("tab", "add_warden_form")));
        stage.setTitle("Add Warden");
        stage.setScene(new Scene(root1, 1054, 650));
        stage.show();
    }
}
