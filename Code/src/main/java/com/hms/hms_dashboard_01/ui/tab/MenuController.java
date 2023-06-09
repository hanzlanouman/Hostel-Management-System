package com.hms.hms_dashboard_01.ui.tab;

import com.hms.hms_dashboard_01.model.entities.Menu;
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

public class MenuController implements Initializable {
    @FXML
    private TableColumn<Menu, Integer> MenuID;

    @FXML
    private TableColumn<Menu, String> Day;

    @FXML
    private TableColumn<Menu, String> Breakfast;

    @FXML
    private TableColumn<Menu, String> Lunch;

    @FXML
    private TableColumn<Menu, String> Dinner;

    @FXML
    private TableView<Menu> MenuTable;

        ObservableList<Menu> MenuList = FXCollections.observableArrayList(
       new Menu(1,"Monday","Bread","Rice","Rice"),
         new Menu(2,"Tuesday","Bread","Rice","Rice"),
            new Menu(3,"Wednesday","Bread","Rice","Rice")

    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MenuID.setCellValueFactory(new PropertyValueFactory<>("MenuID"));
        Day.setCellValueFactory(new PropertyValueFactory<>("Day"));
        Breakfast.setCellValueFactory(new PropertyValueFactory<>("Breakfast"));
        Lunch.setCellValueFactory(new PropertyValueFactory<>("Lunch"));
            Dinner.setCellValueFactory(new PropertyValueFactory<>("Dinner"));
        MenuTable.setItems(MenuList);
    }

    public void addMenu(ActionEvent e) throws IOException {
//       set the stage scene to add Incident
        Stage stage = new Stage();
        Parent root1 = FXMLLoader.load(getClass().getResource(path.getPath("tab", "add_menu_form")));
        stage.setTitle("Add Menu");
        stage.setScene(new Scene(root1, 1054, 650));
        stage.show();
    }
}
