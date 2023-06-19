package com.hms.hms_dashboard_01.controller.tab;
import com.hms.hms_dashboard_01.DTO.MenuDTO;
import com.hms.hms_dashboard_01.Validators.IncidentFormValidator;
import com.hms.hms_dashboard_01.Factory.HMSFactory;
import com.hms.hms_dashboard_01.Validators.MenuFormValidator;
import com.hms.hms_dashboard_01.dal.DALMenuManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class MenuFormController {

    @FXML
    private TextField Day1;
    @FXML
    private TextField Breakfast1;
    @FXML
    private TextField Lunch1;
    @FXML
        private TextField Dinner1;

    public void addMenu(ActionEvent e){



        MenuDTO Menu = HMSFactory.getInstanceOfMenu();
        Menu.setDay(String.join(Day1.getText()));
        Menu.setBreakfast(String.join(Breakfast1.getText()));
        Menu.setLunch(String.join(Lunch1.getText()));
        Menu.setDinner(String.join(Dinner1.getText()));
        //Response
        //use database to insert the fields into the database
        //Make one validator to validate all the fields for Forms
//
        if (!MenuFormValidator.isValidMenuInfo(Menu)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Information");
            alert.setHeaderText("Invalid Information");
            alert.setContentText("Please enter valid information");
            alert.showAndWait();
        }else {
            DALMenuManager.addMenu(Menu);

        }
    }
}
