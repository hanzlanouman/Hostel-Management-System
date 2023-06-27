package com.hms.hms_dashboard_01.controllers;

import com.hms.hms_dashboard_01.DTO.WardenDTO;
import com.hms.hms_dashboard_01.dal.DALWardenManager;

public class WardenManager {
    public static void addWarder(WardenDTO warden){
        DALWardenManager.addWarden(warden);
    }
    public static void deleteWarden(int wardenId){
        DALWardenManager.deleteWarden(wardenId);
    }
}
