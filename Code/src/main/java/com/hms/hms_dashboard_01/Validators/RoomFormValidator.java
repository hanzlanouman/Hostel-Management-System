package com.hms.hms_dashboard_01.Validators;

import com.hms.hms_dashboard_01.DTO.RoomDTO;
import com.hms.hms_dashboard_01.utility.Session;

public class RoomFormValidator {
    public static String validateFields(RoomDTO room){
        if(!isNumeric(String.valueOf(room.getRoomNo())) || room.getRoomNo() == 0){
            return "Room number must be a numeric value. (e.g. 1, 2, 333, ...)";
        }else if(room.getRoomType() == null || room.getRoomType().isEmpty()){
            return "Please enter a valid room type. (e.g. Single, Double, ...)";
        }else if(room.getRoomStatus() == null || room.getRoomStatus().isEmpty()){
            return "Please enter a valid room status.   (e.g. Available, Occupied, ...) ";
        }else if( !isNumeric(String.valueOf(room.getRoomFee())) || room.getRoomFee() <= 0){
            return "Please enter a valid room price. (e.g. 1000, 2000, ...)";
        }else if(room.getRoomBuilding() == null || room.getRoomBuilding().isEmpty()){
            return "Please enter a valid room building. (e.g. A, B, ...)";
        }else if(room.getRoomFloor() == null || room.getRoomFloor().isEmpty()){
            return "Please enter a valid room floor. (e.g. 1, 2, ...)";
        }else if(Session.getRole()!= "admin"){
            return "You are not authorized to perform this action.";
        }else if(room.getRoomFee() == 0 || room.getRoomFee() < 0){
            return "Please enter a valid room price. (e.g. 1000, 2000, ...)";
        }
        return null;
    }
    private static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}