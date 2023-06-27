package com.hms.hms_dashboard_01.ui.tab;

import com.hms.hms_dashboard_01.controllers.StudentManager;
import com.hms.hms_dashboard_01.ui.StudentFormController;
import com.hms.hms_dashboard_01.dal.DALStudentManager;
import com.hms.hms_dashboard_01.model.entities.Student;
import com.hms.hms_dashboard_01.utility.path;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
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

    ObservableList<Student> studentList = FXCollections.observableArrayList(Objects.requireNonNull(DALStudentManager.getAllStudents()));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadTable();

    }
    public void loadTable(){
        studentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        studentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        studentContact.setCellValueFactory(new PropertyValueFactory<>("studentContact"));
        studentEmail.setCellValueFactory(new PropertyValueFactory<>("studentEmail"));

        studentTable.setItems(studentList);
    }

    public void refresh(){
//        refresh the table view
        studentTable.setItems(studentList);
    }
//    Write a search method
    public void search(KeyEvent keyEvent) {
        ObservableList<Student> searchList = FXCollections.observableArrayList();
        for (Student student : studentList){
            if (student.getStudentName().toLowerCase().contains(searchBar.getText().toLowerCase())){
                searchList.add(student);
            }
        }
        studentTable.setItems(searchList);
    }

    public void addStudent(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(path.getPath("tab", "StudentTab_add"))));
        stage.setTitle("Add Student");
        stage.setScene(new Scene(root1, 1054, 650));
        stage.show();
    }

    public void deleteStudent(ActionEvent actionEvent) {
        Student student = studentTable.getSelectionModel().getSelectedItem();
        if(student != null){
            StudentManager.deleteStudent(student.getStudentId());
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No Student Selected");
            alert.setContentText("Please select a student to delete");
            alert.showAndWait();

        }
        refresh();
    }


    public void modifyStudent(ActionEvent e) {

//        open the modify student form
        Student student = studentTable.getSelectionModel().getSelectedItem();
        if (student != null) {
            try {
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource(path.getPath("tab", "StudentTab_add")));
                Parent root1 = loader.load();
                StudentFormController studentFormController = loader.getController();
                studentFormController.setStudentController(this);
                studentFormController.setStudent(student);
                stage.setTitle("Modify Student");
                stage.setScene(new Scene(root1, 1054, 650));
                stage.show();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No Student Selected");
            alert.setContentText("Please select a student to modify");
            alert.showAndWait();
        }


    }
}


