//package com.hms.hms_dashboard_01.Validators;
//import javafx.scene.control.TextField;
//
//public class IncidentFormValidator {
//    //Response
//    //use database to insert the fields into the database
//    //Make one validator to validate all the fields for Forms
//    public static boolean validateIncidentDetails(TextField Date, TextField Day, TextField Location, TextField Time, TextField Description) {
//        if (Date.getText().isEmpty() || Day.getText().isEmpty() || Location.getText().isEmpty() ||
//                Time.getText().isEmpty() || Description.getText().isEmpty()) {
//            System.out.println("Please fill in all fields.");
//            return false;
//        }
//        // Additional validation logic for specific fields
//        if (!isValidDate(Date.getText())) {
//            System.out.println("Invalid date format. Please enter a valid date.");
//            return false;
//        }
//
//        if (!isValidTime(Time.getText())) {
//            System.out.println("Invalid time format. Please enter a valid time.");
//            return false;
//        }
//
//        return true;
//    }
//
//    private static boolean isValidDate(String date) {
//        // Example: Check if the date follows a specific format (YYYY-MM-DD)
//        String regex = "\\d{4}-\\d{2}-\\d{2}";
//        return date.matches(regex);
//    }
//
//    private static boolean isValidTime(String Time) {
//        // Example: Check if the time follows a specific format (HH:mm)
//        String regex = "\\d{2}:\\d{2}";
//        return Time.matches(regex);
//    }
//
//    }
//

package com.hms.hms_dashboard_01.Validators;

import com.hms.hms_dashboard_01.DTO.IncidentDTO;

public class IncidentFormValidator {

    public static boolean isValidInfo(IncidentDTO incident){
//        return incident.getDate() != null && incident.getDay() != null && incident.getLocation() != null && incident.getTime() != null && incident.getDescription() != null ;
        return true;
    }}