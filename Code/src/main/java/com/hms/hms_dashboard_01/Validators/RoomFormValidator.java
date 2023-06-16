package com.hms.hms_dashboard_01.Validators;

import com.hms.hms_dashboard_01.DTO.RoomDTO;

public class RoomFormValidator {

   public static void isValidInfo(RoomDTO room){
         if(room.getRoomNo() == 0){
              System.out.println("Room number cannot be empty");
         }
            if(room.getRoomType() == null){
                System.out.println("Room type cannot be empty");
            }
            if(room.getRoomFloor() == null){
                System.out.println("Room floor cannot be empty");
            }
            if(room.getRoomAvb() == null){
                System.out.println("Room availability cannot be empty");
            }
         if(room.getRoomFee() == 0){
              System.out.println("Room fee cannot be empty");
         }
         if(room.getRoomBuilding() == null){
              System.out.println("Room building cannot be empty");
         }
   }
}
