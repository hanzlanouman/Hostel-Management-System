package com.hms.hms_dashboard_01.Validators;

import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class wardenFormValidator {
    public static boolean validateFields(TextField id, TextField wardenname, TextField contact, TextField email, TextField adress) {
        if ((Integer.parseInt(id.getText()) == 0 )|| wardenname.getText().isEmpty() || contact.getText().isEmpty() || email.getText().isEmpty() || adress.getText().isEmpty() ){
            System.out.println("Please fill all fields.");
            return false;
        }



        // Additional validation logic
        if (!isNumeric(id.getText())) {
            System.out.println("ID must be a numeric value.");
            return false;
        }

        if (!isValidPhoneNo(contact.getText())) {
            System.out.println("Invalid contact number. Please enter a valid phone number.");
            return false;
        }

        return true;
    }

    private static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isValidPhoneNo(String contactNo) {
        // Example: Regular expression validation for a 11-digit phone number
        String regex = "\\d{11}";
        return contactNo.matches(regex);
    }
}
