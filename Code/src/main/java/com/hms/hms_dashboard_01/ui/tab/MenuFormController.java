package com.hms.hms_dashboard_01.ui.tab;
import com.hms.hms_dashboard_01.DTO.MenuDTO;
import com.hms.hms_dashboard_01.Factory.HMSFactory;
import com.hms.hms_dashboard_01.Validators.MenuFormValidator;
import com.hms.hms_dashboard_01.dal.DALMenuManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Objects;


public class MenuFormController {
    @FXML
    private TextField MenuID;
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


        if(Objects.equals(MenuID.getText(), ""))
        {
            Menu.setMenuID(0);
        } else
        {
            Menu.setMenuID(Integer.parseInt(MenuID.getText()));
        }
        Menu.setDay(Day1.getText());
        Menu.setBreakfast(Breakfast1.getText());
        Menu.setLunch(Lunch1.getText());
        Menu.setDinner(Dinner1.getText());

        System.out.println(Menu.getDinner());

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
//            Show Confirmation alert and close the stage
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Success");
            alert.setContentText("Menu Added Successfully");
            alert.showAndWait();

            Stage stage = (Stage) Day1.getScene().getWindow();
            stage.close();


        }
    }
}
