package com.hms.hms_dashboard_01.controller.tab;

import com.hms.hms_dashboard_01.DTO.RoomDTO;
import com.hms.hms_dashboard_01.Factory.HMSFactory;
import com.hms.hms_dashboard_01.Validators.RoomFormValidator;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

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


    public void addRoom(ActionEvent e){


        RoomDTO room = HMSFactory.getInstanceOfRoom();

        if (Objects.equals(roomNo.getText(), "")) {
            room.setRoomNo(0);
        } else {
            room.setRoomNo(Integer.parseInt(roomNo.getText()));
        }
        if(Objects.equals(roomFee.getText(), "")){
            room.setRoomFee(0);
        } else {
            room.setRoomFee(Integer.parseInt(roomFee.getText()));
        }
        room.setRoomType(roomType.getValue());
        room.setRoomFloor(roomFloor.getValue());
        room.setRoomAvb(roomAvb.getValue());
        room.setRoomBuilding(roomBuilding.getValue());
        if (!RoomFormValidator.isValidInfo(room)){
//            Pop an alert saying invalid info
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Information");
            alert.setHeaderText("Invalid Information");
            alert.setContentText("Please enter valid information");
            alert.showAndWait();

        }

        System.out.println(room.getRoomFloor());
    }

    public void initialize(URL url, ResourceBundle rb) {

//        Add Choices to Choice Boxes
        roomType.getItems().addAll("Single", "Double", "Triple");
        roomFloor.getItems().addAll("1st Floor", "2nd Floor", "3rd Floor", "4th Floor", "5th Floor");
        roomAvb.getItems().addAll("Available", "Unavailable");
        roomBuilding.getItems().addAll("A", "B", "C", "D", "E", "F", "G", "H");
    }
}
