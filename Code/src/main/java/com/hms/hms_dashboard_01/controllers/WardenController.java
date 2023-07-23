package com.hms.hms_dashboard_01.controllers;

import com.hms.hms_dashboard_01.DTO.WardenDTO;
import com.hms.hms_dashboard_01.Factory.HMSFactory;
import com.hms.hms_dashboard_01.Validators.wardenFormValidator;
import com.hms.hms_dashboard_01.dal.DALWardenManager;

import java.util.List;

import static java.lang.Integer.parseInt;

public class WardenController {
    public  String addWarder(WardenDTO warden) {

        String validationError = wardenFormValidator.validateFields(warden);

        if(validationError == null){
            return DALWardenManager.addWarden(warden);
            }
        else{
            return validationError;
        }

    }
    public  void deleteWarden(int wardenId){
        DALWardenManager.deleteWarden(wardenId);
    }
    public  List<WardenDTO> getAllWardens(){
        return DALWardenManager.getAllWardens();
    }
}
