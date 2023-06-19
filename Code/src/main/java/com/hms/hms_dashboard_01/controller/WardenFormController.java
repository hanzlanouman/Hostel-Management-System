package com.hms.hms_dashboard_01.controller;

import com.hms.hms_dashboard_01.DTO.StaffDTO;
import com.hms.hms_dashboard_01.DTO.WardenDTO;
import com.hms.hms_dashboard_01.Factory.HMSFactory;
import com.hms.hms_dashboard_01.dal.DALWardenManager;
import com.hms.hms_dashboard_01.model.entities.Warden;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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

    public void addWarden(){
        System.out.println("Warden Added successfully");

        WardenDTO warden = HMSFactory.getInstanceOfWarden();
        warden.setWardenId((parseInt(wardenId.getText())));
        warden.setWardenName(wardenName.getText());
        warden.setWardenEmail(wardenEmail.getText());
        warden.setAddress(wardenAddress.getText());
        warden.setAddress(wardenPhone.getText());

        DALWardenManager.addWarden(warden);
    }
}
