package com.hms.hms_dashboard_01.Factory;

import com.hms.hms_dashboard_01.DTO.RoomDTO;
import com.hms.hms_dashboard_01.DTO.StaffDTO;
import com.hms.hms_dashboard_01.DTO.WardenDTO;
import com.hms.hms_dashboard_01.model.entities.Warden;

public class HMSFactory
{
    public static RoomDTO getInstanceOfRoom()
    {
        return new RoomDTO();
    }
    public static StaffDTO getInstanceOfStaff()
    {
        return new StaffDTO();
    }

    public  static WardenDTO getInstanceOfWarden(){return new WardenDTO();}


}
