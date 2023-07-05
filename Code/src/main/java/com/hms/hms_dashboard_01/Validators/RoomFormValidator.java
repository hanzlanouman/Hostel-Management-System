package com.hms.hms_dashboard_01.Validators;

import com.hms.hms_dashboard_01.DTO.RoomDTO;
import com.hms.hms_dashboard_01.utility.Session;

public class RoomFormValidator {

    public static String validateFields(RoomDTO room){
        if(!isNumeric(String.valueOf(room.getRoomNo()))){
            return "Room number must be a numeric value.";
        }else if(room.getRoomType() == null || room.getRoomType().isEmpty()){
            return "Please enter a valid room type.";
        }else if(room.getRoomStatus() == null || room.getRoomStatus().isEmpty()){
            return "Please enter a valid room status.";
        }else if( !isNumeric(String.valueOf(room.getRoomFee()))){
            return "Please enter a valid room price.";
        }else if(room.getRoomBuilding() == null || room.getRoomBuilding().isEmpty()){
            return "Please enter a valid room building.";
        }else if(room.getRoomFloor() == null || room.getRoomFloor().isEmpty()){
            return "Please enter a valid room floor.";
        }else if(Session.getRole()!= "admin"){
            return "You are not authorized to perform this action.";
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