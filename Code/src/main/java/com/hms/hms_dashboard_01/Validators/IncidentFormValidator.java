package com.hms.hms_dashboard_01.Validators;
import javafx.scene.control.TextField;

public class IncidentFormValidator {

    public static boolean validateFields(TextField Date, TextField Day, TextField Location, TextField Time, TextField Description) {
        if (Date.getText().isEmpty() || Day.getText().isEmpty() || Location.getText().isEmpty() ||
                Time.getText().isEmpty() || Description.getText().isEmpty()) {
            System.out.println("Please fill in all fields.");
            return false;
        }
        // Additional validation logic for specific fields
        if (!isValidDate(Date.getText())) {
            System.out.println("Invalid date format. Please enter a valid date.");
            return false;
        }

        // Add more validation logic for other fields if needed

        return true;
    }

    private static boolean isValidDate(String date) {
        // Example: Check if the date follows a specific format (YYYY-MM-DD)
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        return date.matches(regex);
    }

    }

