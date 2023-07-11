package com.hms.hms_dashboard_01.ui.tab;

import com.hms.hms_dashboard_01.DTO.FeedBackDTO;
import com.hms.hms_dashboard_01.DTO.IncidentDTO;
import com.hms.hms_dashboard_01.Validators.IncidentFormValidator;
import com.hms.hms_dashboard_01.Factory.HMSFactory;
import com.hms.hms_dashboard_01.controllers.IncidentController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Objects;

public class FeedBackFormController{

    @FXML
    private TextField description;

    @FXML
    private TextField stuName;

    @FXML
    private TextField contactNo;

    @FXML
    private TextField feedSub;

    @FXML
    private TextField feedCategory;

    @FXML
    private TextField stuId;

    @FXML
    private TextField feedDes;

    @FXML
    private TextField roomNo;

    private IncidentTabController incidentTabController;

    public void setIncidentController(IncidentTabController incidentTabController) {
        this.incidentTabController = incidentTabController;
    }

    public void addFeedBack(ActionEvent e) {
        FeedBackDTO feedBack = HMSFactory.getInstanceOfFeedBack();

        feedBack.setstu_Name(stuName.getText());
        feedBack.setContact_No(contactNo.getText());
        feedBack.setFeed_Sub(feedSub.getText());
        feedBack.setFeed_category(feedCategory.getText());
        feedBack.setRoom_No(Integer.parseInt(roomNo.getText()));
        feedBack.setfeed_Des(feedDes.getText());


        if (Objects.equals(stuId.getText(), "")) {
            feedBack.setStu_ID(0);
        } else {
            try {
                int id = Integer.parseInt(stuId.getText());
                feedBack.setStu_ID(id);
            } catch (NumberFormatException ex) {
                // Display error message for invalid student ID
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Information");
                alert.setHeaderText("Invalid Student ID");
                alert.setContentText("Please enter a valid numeric value for the Student ID.");
                alert.showAndWait();
                return; // Stop further processing
            }
        }



    }
}
