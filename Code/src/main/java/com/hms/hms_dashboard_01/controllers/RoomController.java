package com.hms.hms_dashboard_01.controllers;

import com.hms.hms_dashboard_01.DTO.RoomDTO;
import com.hms.hms_dashboard_01.Factory.HMSFactory;
import com.hms.hms_dashboard_01.Validators.RoomFormValidator;
import com.hms.hms_dashboard_01.dal.DALRoomManager;
import com.hms.hms_dashboard_01.model.entities.Room;

import java.util.List;

public class RoomController {

    public  String addRoom(RoomDTO room){

        String validationError = RoomFormValidator.validateFields(room);
        if(validationError == null){
            return DALRoomManager.addRoom(room);
        }else{
            return validationError;
        }
    }
    public  void deleteRoom(int roomNo){
        DALRoomManager.deleteRoom(roomNo);
    }

    public  List<Room> getAllRooms(){
        return DALRoomManager.getAllRooms();
    }
}
