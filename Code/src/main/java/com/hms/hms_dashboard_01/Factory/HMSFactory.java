package com.hms.hms_dashboard_01.Factory;

import com.hms.hms_dashboard_01.DTO.*;

public class HMSFactory
{
    public static RoomDTO getInstanceOfRoom()
    {
        return new RoomDTO();
    }

    public static StudentDTO getInstanceOfStudent(){return new StudentDTO();}

    public static StaffDTO getInstanceOfStaff()
    {
        return new StaffDTO();
    }

    public  static WardenDTO getInstanceOfWarden(){return new WardenDTO();}
    public  static IncidentDTO getInstanceOfIncident(){return new IncidentDTO();}
    public  static FeedBackDTO getInstanceOfFeedBack(){return new FeedBackDTO();}

}
