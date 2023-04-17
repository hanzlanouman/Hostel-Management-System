package com.hms.hms_dashboard_01;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {


    @FXML
    private TableColumn<Student, String> studentContact;

    @FXML
    private TableColumn<Student, String> studentEmail;

    @FXML
    private TableColumn<Student, Integer> studentId;

    @FXML
    private TableColumn<Student, String> studentName;

    @FXML
    private TableView<Student> studentTable;

    ObservableList<Student> studentList = FXCollections.observableArrayList(
            new Student(1, "Ali", "123456789", "ali@email.com"),
            new Student(2, "Ahmed", "123456789", "ahmed@email.com")

    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        studentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        studentContact.setCellValueFactory(new PropertyValueFactory<>("studentContact"));
        studentEmail.setCellValueFactory(new PropertyValueFactory<>("studentEmail"));

        studentTable.setItems(studentList);




    }
}
