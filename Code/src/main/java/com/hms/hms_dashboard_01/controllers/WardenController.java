package com.hms.hms_dashboard_01.controllers;

import com.hms.hms_dashboard_01.DTO.WardenDTO;
import com.hms.hms_dashboard_01.dal.DALWardenManager;

import java.util.List;

public class WardenController {
    public static void addWarder(WardenDTO warden){
        DALWardenManager.addWarden(warden);
    }
    public static void deleteWarden(int wardenId){
        DALWardenManager.deleteWarden(wardenId);
    }
    public static List<WardenDTO> getAllWardens(){
        return DALWardenManager.getAllWardens();
    }
}
