package com.hms.hms_dashboard_01.Validators;

import com.hms.hms_dashboard_01.DTO.RoomDTO;

public class RoomFormValidator {

   public static boolean isValidInfo(RoomDTO room){
        return room.getRoomNo() != 0 && room.getRoomFee() != 0 && room.getRoomType() != null && room.getRoomFloor() != null && room.getRoomAvb() != null && room.getRoomBuilding() != null;
}}