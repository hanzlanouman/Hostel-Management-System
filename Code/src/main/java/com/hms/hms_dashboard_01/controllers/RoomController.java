package com.hms.hms_dashboard_01.controllers;

import com.hms.hms_dashboard_01.DTO.RoomDTO;
import com.hms.hms_dashboard_01.dal.DALRoomManager;
import com.hms.hms_dashboard_01.model.entities.Room;

import java.util.List;

public class RoomController {

    public static String addRoom(RoomDTO room){
        return DALRoomManager.addRoom(room);
    }
    public static void deleteRoom(int roomNo){
        DALRoomManager.deleteRoom(roomNo);
    }

    public static List<Room> getAllRooms(){
        return DALRoomManager.getAllRooms();
    }
}
