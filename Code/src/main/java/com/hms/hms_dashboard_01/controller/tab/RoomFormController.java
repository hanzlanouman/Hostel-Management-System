package com.hms.hms_dashboard_01.controller.tab;

import com.hms.hms_dashboard_01.DTO.RoomDTO;
import com.hms.hms_dashboard_01.Factory.HMSFactory;
import com.hms.hms_dashboard_01.Validators.RoomFormValidator;
import com.hms.hms_dashboard_01.dal.DALRoomManager;
import com.hms.hms_dashboard_01.model.entities.Room;
import javafx.collections.ObservableList;
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

    private RoomController roomController;
    public void setRoomController(RoomController roomController) {
        this.roomController = roomController;
    }

    public void addRoom(ActionEvent e){

        RoomDTO room = HMSFactory.getInstanceOfRoom();
        try {
            room.setRoomNo(roomNo.getText().isEmpty() ? 0 : Integer.parseInt(roomNo.getText()));
        } catch (NumberFormatException nfe) {
            showAlert("Invalid room number");
            return;
        }
        try {
            room.setRoomFee(roomFee.getText().isEmpty() ? 0 : Integer.parseInt(roomFee.getText()));
        } catch (NumberFormatException nfe) {
            showAlert("Invalid room fee");
            return;
        }
        room.setRoomType(roomType.getValue());
        room.setRoomStatus(roomAvb.getValue());
        room.setRoomFloor(roomFloor.getValue());
        room.setRoomAvb(roomAvb.getValue());
        room.setRoomBuilding(roomBuilding.getValue());
        String validationError = RoomFormValidator.validateFields(room);
        if (validationError != null) {
            showAlert(validationError);
        } else {
            String response = DALRoomManager.addRoom(room);
            if (Objects.equals(response, "success")) {
                successClose();
            } else {
                showAlert("Database Error");
            }
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void successClose(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Success");
        alert.setContentText("Room Added Successfully");
        alert.showAndWait();
        roomController.updateRoomTable();
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
