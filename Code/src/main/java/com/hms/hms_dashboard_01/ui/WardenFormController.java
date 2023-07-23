package com.hms.hms_dashboard_01.ui;

import com.hms.hms_dashboard_01.DTO.WardenDTO;
import com.hms.hms_dashboard_01.Factory.HMSFactory;
import com.hms.hms_dashboard_01.Validators.wardenFormValidator;
import com.hms.hms_dashboard_01.controllers.WardenController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static java.lang.Integer.parseInt;

public class WardenFormController {
    @FXML
    private TextField wardenAddress;

    @FXML
    private TextField wardenEmail;

    @FXML
    private TextField wardenId;

    @FXML
    private TextField wardenName;

    @FXML
    private TextField wardenPhone;

    public void addWarden() {
        WardenDTO wardenDTO = HMSFactory.getInstanceOfWarden();
        try{
            wardenDTO.setWardenId(parseInt(wardenId.getText()));
        }catch (NumberFormatException e){
            showAlert("Invalid Warden ID: Warden ID should be a number like 123, 250");
            return;
        }
        wardenDTO.setWardenName(wardenName.getText());
        wardenDTO.setWardenEmail(wardenEmail.getText());
        wardenDTO.setWardenContact(wardenPhone.getText());
        wardenDTO.setAddress(wardenAddress.getText());


        WardenController wardenController = HMSFactory.getInstanceOfWardenController();

        String validationError = wardenController.addWarder(wardenDTO);
        if (validationError != null) {
            if(validationError.equals("success")){
                successClose();
                return;
            }
            showAlert(validationError);
        } else {
            successClose();
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void successClose() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Success");
        alert.setContentText("Warden Added Successfully");
        alert.showAndWait();
        Stage stage = (Stage) wardenId.getScene().getWindow();
        stage.close();
        }
    }

