package com.hms.hms_dashboard_01.controller.tab;

import com.hms.hms_dashboard_01.model.entities.Room;
import com.hms.hms_dashboard_01.model.entities.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {

@FXML
private TextField searchBar;
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
    public void deleteStudent(ActionEvent e){
        Alert deleteRoomAlert = new Alert(Alert.AlertType.CONFIRMATION);
        deleteRoomAlert.setTitle("Delete Student");
        deleteRoomAlert.setHeaderText("Are you sure you want to delete this student?");
        if (deleteRoomAlert.showAndWait().get().equals(ButtonType.CANCEL)) {
            return;
        }
        studentTable.getItems().removeAll(studentTable.getSelectionModel().getSelectedItem());

    }

}
