//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.hms.hms_dashboard_01.ui.tab;

import com.hms.hms_dashboard_01.controllers.IncidentController;
import com.hms.hms_dashboard_01.model.entities.Incident;
import com.hms.hms_dashboard_01.model.entities.feedback;
import com.hms.hms_dashboard_01.utility.path;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FeedBackTabController implements Initializable {
    @FXML
    private TableColumn<feedback, String> stuName;
    @FXML
    private TableColumn<feedback, String> contactNo;
    @FXML
    private TableColumn<feedback, String> feedSub;
    @FXML
    private TableColumn<feedback, String> feedCategory;
    @FXML
    private TableColumn<feedback, Integer> stuId;
    @FXML
    private TableColumn<feedback, String> feedDes;
    @FXML
    private TableColumn<feedback, Integer> roomNo;
    @FXML
    private TableView<feedback> FeedBackTable;

    ObservableList<feedback> FeedBackList = FXCollections.observableArrayList();

    public FeedBackTabController() {
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadTable();
    }

    public void loadTable() {
        stuName.setCellValueFactory(new PropertyValueFactory<>("stu_Name"));
        contactNo.setCellValueFactory(new PropertyValueFactory<>("Contact_No"));
        feedSub.setCellValueFactory(new PropertyValueFactory<>("Feed_Sub"));
        feedCategory.setCellValueFactory(new PropertyValueFactory<>("Feed_category"));
        stuId.setCellValueFactory(new PropertyValueFactory<>("Stu_ID"));
        feedDes.setCellValueFactory(new PropertyValueFactory<>("feed_Des"));
        roomNo.setCellValueFactory(new PropertyValueFactory<>("Room_No"));

        FeedBackTable.setItems(FeedBackList);
    }

}
//    public void addIncident(ActionEvent e) throws IOException {
//        Stage stage = new Stage();
//        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(path.getPath("tab", "FeedBack_Add")));
//        Parent root1 = (Parent)loader.load();
//        FeedBackFormController feedBackFormController = (feedBackFormController)loader.getController();
//        feedBackFormController.setfeedBackController(this);
//        stage.setTitle("Add Feedback");
//        stage.setScene(new Scene(root1, 1054.0, 650.0));
//        stage.show();
//    }




