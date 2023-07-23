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
            DALRoomManager dalRoomManager = HMSFactory.getInstanceOfRoomManager();
            return dalRoomManager.addRoom(room);
        }else{
            return validationError;
        }
    }
    public  void deleteRoom(int roomNo){
        DALRoomManager dalRoomManager = HMSFactory.getInstanceOfRoomManager();
        dalRoomManager.deleteRoom(roomNo);
    }

    public  List<Room> getAllRooms(){

        DALRoomManager dalRoomManager = HMSFactory.getInstanceOfRoomManager();
        return dalRoomManager.getAllRooms();
    }
}
