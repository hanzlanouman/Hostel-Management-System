package com.hms.hms_dashboard_01.controller.tab;

import com.hms.hms_dashboard_01.DTO.RoomDTO;
import com.hms.hms_dashboard_01.Factory.HMSFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.awt.*;

public class RoomFormController {

    @FXML
    private TextField roomNo;

    @FXML
    private TextField roomCap;


    public void addRoom(ActionEvent e){

        RoomDTO room = HMSFactory.getInstanceOfRoom();
        room.setRoomNo(Integer.parseInt(roomNo.getText()));
        room.setRoomFee(Integer.parseInt(roomCap.getText()));

        System.out.println(room.getRoomNo());
        System.out.println(room.getRoomFee());
    }
}
