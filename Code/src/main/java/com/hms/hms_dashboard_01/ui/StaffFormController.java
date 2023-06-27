package com.hms.hms_dashboard_01.ui;

import com.hms.hms_dashboard_01.DTO.StaffDTO;
import com.hms.hms_dashboard_01.Factory.HMSFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import static java.lang.Integer.parseInt;

public class StaffFormController {

@FXML
private TextField staffName;
@FXML
private TextField staffId;

@FXML
private TextField staffEmail;

@FXML
private TextField staffGender;

@FXML
private TextField staffAddress;


 public void addStaff (ActionEvent e){
     StaffDTO staff = HMSFactory.getInstanceOfStaff();
    staff.setStaffId(parseInt(staffId.getText()));
     staff.setStaffName(staffName.getText());
     staff.setStaffEmail(staffEmail.getText());
     staff.setAddress(staffAddress.getText());
     staff.setGender(staffGender.getText());

     System.out.println(staff.getStaffEmail());

 }

}
