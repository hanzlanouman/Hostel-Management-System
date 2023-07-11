package com.hms.hms_dashboard_01.Validators;

import com.hms.hms_dashboard_01.DTO.IncidentDTO;
import com.hms.hms_dashboard_01.utility.Session;

public class IncidentFormValidator {

    public static String validateIncidentDetails(IncidentDTO incident) {
        if (!isNumeric(String.valueOf(incident.getIncidentId()))) {
            return "Incident ID must be a numeric value.";
        }

        if (isEmpty(incident.getDay())) {
            return "Please enter a valid day.";
        }

        if (isEmpty(incident.getDate())) {
            return "Please enter a valid date.";
        }

        if (isEmpty(incident.getLocation())) {
            return "Please enter a valid location.";
        }

        if (isEmpty(incident.getTime())) {
            return "Please enter a valid time.";
        }
        if (isEmpty(incident.getDescription())) {
            return "Please enter a valid description.";
        }else if(Session.getRole()!= "admin"){
            return "You are not authorized to perform this action.";
        }

        return null; // Indicates no validation errors
    }

    private static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    private static boolean isNumeric(String value) {
        return value != null && value.matches("\\d+");
    }
}

