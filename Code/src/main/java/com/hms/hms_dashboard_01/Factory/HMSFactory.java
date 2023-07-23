package com.hms.hms_dashboard_01.Factory;

import com.hms.hms_dashboard_01.DTO.*;
import com.hms.hms_dashboard_01.controllers.IncidentController;
import com.hms.hms_dashboard_01.controllers.RoomController;
import com.hms.hms_dashboard_01.controllers.StudentController;
import com.hms.hms_dashboard_01.controllers.WardenController;
import com.hms.hms_dashboard_01.dal.DALIncidentManager;
import com.hms.hms_dashboard_01.dal.DALRoomManager;
import com.hms.hms_dashboard_01.dal.DALStudentManager;
import com.hms.hms_dashboard_01.dal.DALWardenManager;
import com.hms.hms_dashboard_01.model.entities.Student;
import com.hms.hms_dashboard_01.utility.Session;

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
    public  static MenuDTO getInstanceOfMenu(){return new MenuDTO();}

    public static Session getInstanceofSession(String role)
    {
        return new Session(role);
    }

    public static RoomController getInstanceOfRoomController()
    {
        return new RoomController();
    }
    public static IncidentController getInstanceOfIncidentController()
    {
        return new IncidentController();
    }

    public static StudentController getInstanceOfStudentController()
    {
        return new StudentController();
    }

    public static WardenController getInstanceOfWardenController()
    {
        return new WardenController();
    }

//    Write all methods to get DAL objects
    public static DALRoomManager getInstanceOfRoomManager()
    {
        return new DALRoomManager();
    }
    public static DALIncidentManager getInstanceOfIncidentManager()
    {
        return new DALIncidentManager();
    }
    public static DALStudentManager getInstanceOfStudentManager()
    {
        return new DALStudentManager();
    }
    public static DALWardenManager getInstanceOfWardenManager()
    {
        return new DALWardenManager();
    }

}
