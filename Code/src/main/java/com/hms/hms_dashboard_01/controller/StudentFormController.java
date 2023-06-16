package com.hms.hms_dashboard_01.controller;

import com.hms.hms_dashboard_01.Factory.HMSFactory;
import com.hms.hms_dashboard_01.DTO.StudentDTO;
import com.hms.hms_dashboard_01.Validators.StudentFormValidator;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class StudentFormController {

    @FXML
    private TextField adress;

    @FXML
    private TextField contact;

    @FXML
    private TextField email;

    @FXML
    private TextField fathername;

    @FXML
    private RadioButton feestatus;

    @FXML
    private TextField id;

    @FXML
    private ComboBox<?> roomno;

    @FXML
    private ComboBox<?> roomtype;

    @FXML
    private TextField studentname;

    public void addStudent() {
        if (StudentFormValidator.validateFields(id, studentname, contact, email, fathername, feestatus, adress, roomno, roomtype)) {

            StudentDTO student = HMSFactory.getInstanceOfStudent();
            student.setRollNo(id.getText());
            student.setStudentName(studentname.getText());
            student.setEmail(email.getText());
            student.setAddress(adress.getText());

            System.out.println("Student added");
            System.out.println("Roll No: " + student.getRollNo());
            System.out.println("Student Name: " + student.getStudentName());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Address: " + student.getAddress());

            //further operations with the student object
        }
    }
}


