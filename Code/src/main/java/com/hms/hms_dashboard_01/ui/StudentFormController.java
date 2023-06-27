package com.hms.hms_dashboard_01.ui;

import com.hms.hms_dashboard_01.DTO.StudentDTO;
import com.hms.hms_dashboard_01.Validators.StudentFormValidator;
import com.hms.hms_dashboard_01.controllers.StudentController;
import com.hms.hms_dashboard_01.ui.tab.StudentTabController;
import com.hms.hms_dashboard_01.model.entities.Student;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class StudentFormController {

    private StudentTabController studentTabController;
    private Student student = new Student();

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

    public void setStudentController(StudentTabController studentTabController) {
        this.studentTabController = studentTabController;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void addStudent() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setRollNo(id.getText());
        studentDTO.setStudentName(studentname.getText());
        studentDTO.setEmail(email.getText());
        studentDTO.setAddress(adress.getText());
        studentDTO.setStudentContact(contact.getText());

        String validationError = StudentFormValidator.validateFields(studentDTO);
        if (validationError != null) {
            // Display specific error message based on the validation error
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Information");
            alert.setHeaderText("Invalid Information");
            alert.setContentText(validationError);
            alert.showAndWait();
        } else {
            StudentController.addStudent(studentDTO);
            // Show success alert and close the stage
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Student Added!");
            alert.setContentText("Student added successfully");
            alert.showAndWait();
            Stage stage = (Stage) id.getScene().getWindow();
            stage.close();
        }
    }
}
