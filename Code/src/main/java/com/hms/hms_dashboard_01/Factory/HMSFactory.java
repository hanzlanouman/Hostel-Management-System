package com.hms.hms_dashboard_01.Factory;

import com.hms.hms_dashboard_01.DTO.RoomDTO;

public class HMSFactory
{
    public static RoomDTO getInstanceOfRoom()
    {
        return new RoomDTO();
    }

}
