package com.hms.hms_dashboard_01.controllers;

import com.hms.hms_dashboard_01.DTO.RoomDTO;
import com.hms.hms_dashboard_01.Factory.HMSFactory;
import com.hms.hms_dashboard_01.Validators.RoomFormValidator;
import com.hms.hms_dashboard_01.dal.DALRoomManager;
import com.hms.hms_dashboard_01.model.entities.Room;

import java.util.List;

public class RoomController {

    public static String addRoom(String roomNo, String roomFee, String roomType, String roomFloor, String roomAvb, String roomBuilding){
        RoomDTO room = HMSFactory.getInstanceOfRoom();
        try {
            room.setRoomNo(roomNo.isEmpty() ? 0 : Integer.parseInt(roomNo));
        } catch (NumberFormatException nfe) {

            return "Invalid room number";
        }
        try {
            room.setRoomFee(roomFee.isEmpty() ? 0 : Integer.parseInt(roomFee));
        } catch (NumberFormatException nfe) {
            return "Invalid room fee";
        }
        room.setRoomType(roomType);
        room.setRoomStatus(roomAvb);
        room.setRoomFloor(roomFloor);
        room.setRoomAvb(roomAvb);
        room.setRoomBuilding(roomBuilding);

        String validationError = RoomFormValidator.validateFields(room);

        if(validationError == null){
            DALRoomManager.addRoom(room);
            return null;
        }else{
            return validationError;
        }
    }
    public static void deleteRoom(int roomNo){
        DALRoomManager.deleteRoom(roomNo);
    }

    public static List<Room> getAllRooms(){
        return DALRoomManager.getAllRooms();
    }
}
