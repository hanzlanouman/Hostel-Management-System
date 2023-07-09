package com.hms.hms_dashboard_01.Validators;

import com.hms.hms_dashboard_01.DTO.WardenDTO;
import com.hms.hms_dashboard_01.utility.Session;

public class wardenFormValidator {

    public static String validateFields(WardenDTO warden){
        if(warden.getWardenId() == 0 || warden.getWardenId() < 0){
            return "Please enter a valid ID.";
        } else if (!isNumeric(String.valueOf(warden.getWardenId())) ) {
            return "ID must be a numeric value.";
        } else if (warden.getWardenName().isEmpty() || warden.getWardenName().length() < 3 || warden.getWardenName().length() > 50 || warden.getWardenName() == null) {
            return "Please enter a valid warden name.";
        } else if (warden.getWardenEmail().isEmpty() || warden.getWardenEmail().length() < 3 || warden.getWardenEmail().length() > 50 || warden.getWardenEmail() == null) {
            return "Please enter a valid email.";
        } else if (warden.getAddress().isEmpty() || warden.getAddress().length() < 3 || warden.getAddress().length() > 50 || warden.getAddress() == null) {
            return "Please enter a valid address.";
        } else if (warden.getWardenContact().isEmpty() || !isNumeric(warden.getWardenContact()) || warden.getWardenContact().length() < 3 || warden.getWardenContact().length() > 50 || warden.getWardenContact() == null) {
            return "Please enter a valid phone number.";
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
