package com.hms.hms_dashboard_01.ui.tab;

import com.hms.hms_dashboard_01.DTO.RoomDTO;
import com.hms.hms_dashboard_01.Factory.HMSFactory;
import com.hms.hms_dashboard_01.Validators.RoomFormValidator;
import com.hms.hms_dashboard_01.controllers.RoomController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class RoomFormController implements Initializable {

    @FXML
    private TextField roomNo;

    @FXML
    private TextField roomFee;

    @FXML
    private ChoiceBox<String> roomType;

    @FXML
    private ChoiceBox<String> roomFloor;

    @FXML
    private ChoiceBox<String> roomAvb;

    @FXML
    private ChoiceBox<String> roomBuilding;

    private RoomTabController roomTabController;
    public void setRoomController(RoomTabController roomTabController) {
        this.roomTabController = roomTabController;
    }

    public void addRoom(ActionEvent e){

        RoomDTO roomDTO = HMSFactory.getInstanceOfRoom();
        roomDTO.setRoomNo(Integer.parseInt(roomNo.getText()));
        roomDTO.setRoomFee(Integer.parseInt(roomFee.getText()));
        roomDTO.setRoomType(Objects.requireNonNull(roomType.getValue()));
        roomDTO.setRoomFloor(Objects.requireNonNull(roomFloor.getValue()));
        roomDTO.setRoomStatus(Objects.requireNonNull(roomAvb.getValue()));
        roomDTO.setRoomBuilding(Objects.requireNonNull(roomBuilding.getValue()));

        RoomController roomController = HMSFactory.getInstanceOfRoomController();
        String validationError = roomController.addRoom(roomDTO);

        if (validationError != null) {
            showAlert(validationError);
        } else {
            successClose();
        }
    }

    private void showAlert(String message) {
        if(Objects.equals(message, "Room added successfully")){
            successClose();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText(message);
            alert.showAndWait();
        }
    }

    public void successClose(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Success");
        alert.setContentText("Room Added Successfully");
        alert.showAndWait();
        roomTabController.updateRoomTable();
        Stage stage = (Stage) roomNo.getScene().getWindow();
        stage.close();
    }

    public void cancel(ActionEvent e){
        Stage stage = (Stage) roomNo.getScene().getWindow();
        stage.close();
    }

    public void initialize(URL url, ResourceBundle rb) {

//        Add Choices to Choice Boxes
        roomType.getItems().addAll("Single", "Double", "Triple");
        roomFloor.getItems().addAll("1st Floor", "2nd Floor", "3rd Floor", "4th Floor", "5th Floor");
        roomAvb.getItems().addAll("Available", "Unavailable");
        roomBuilding.getItems().addAll("A", "B", "C", "D", "E", "F", "G", "H");
    }

}
