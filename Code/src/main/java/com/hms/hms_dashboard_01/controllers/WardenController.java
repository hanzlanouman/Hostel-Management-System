package com.hms.hms_dashboard_01.controllers;

import com.hms.hms_dashboard_01.DTO.WardenDTO;
import com.hms.hms_dashboard_01.Factory.HMSFactory;
import com.hms.hms_dashboard_01.Validators.wardenFormValidator;
import com.hms.hms_dashboard_01.dal.DALWardenManager;

import java.util.List;

import static java.lang.Integer.parseInt;

public class WardenController {
    public static String addWarder( String wardenId, String wardenName, String wardenEmail, String wardenAddress, String wardenPhone) {

        WardenDTO warden = HMSFactory.getInstanceOfWarden();
        try {
            warden.setWardenId(wardenId.isEmpty() ? 0 : parseInt(wardenId));
        } catch (NumberFormatException nfe) {

            return "Invalid warden id";
        }
        warden.setWardenName(wardenName);
        warden.setWardenEmail(wardenEmail);
        warden.setAddress(wardenAddress);
        warden.setWardenContact(wardenPhone);

        String validationError = wardenFormValidator.validateFields(warden);

        if(validationError == null){
            DALWardenManager.addWarden(warden);
            return null;}
        else{
            return validationError;
        }

    }
    public static void deleteWarden(int wardenId){
        DALWardenManager.deleteWarden(wardenId);
    }
    public static List<WardenDTO> getAllWardens(){
        return DALWardenManager.getAllWardens();
    }
}
