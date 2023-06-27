package com.hms.hms_dashboard_01.controllers;

import com.hms.hms_dashboard_01.DTO.RoomDTO;
import com.hms.hms_dashboard_01.dal.DALRoomManager;

public class RoomManager {

    public static String addRoom(RoomDTO room){
        return DALRoomManager.addRoom(room);
    }
    public static void deleteRoom(int roomNo){
        DALRoomManager.deleteRoom(roomNo);
    }
}
