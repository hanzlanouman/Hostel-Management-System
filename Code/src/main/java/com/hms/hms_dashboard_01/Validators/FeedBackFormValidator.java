package com.hms.hms_dashboard_01.Validators;
import com.hms.hms_dashboard_01.utility.Session;
import javafx.scene.control.TextField;
public class FeedBackFormValidator {

    public static boolean validateFields(TextField Stu_ID, TextField stu_Name, TextField Contact_No, TextField Room_No, TextField Feed_Sub, TextField Feed_category,
                                         TextField feed_Des) {
        if (Stu_ID.getText().isEmpty() || stu_Name.getText().isEmpty() || Contact_No.getText().isEmpty() ||
                Room_No.getText().isEmpty() || Feed_Sub.getText().isEmpty() || Feed_category.getText().isEmpty() ||
                feed_Des.getText().isEmpty()) {
            System.out.println("Please fill in all fields.");
            return false;
        }

        // Additional validation logic
        if (!isNumeric(Stu_ID.getText())) {
            System.out.println("Student ID must be a numeric value.");
            return false;
        }

        if (!isNumeric(Room_No.getText())) {
            System.out.println("Room number must be a numeric value.");
            return false;
        }

        if (!isValidContactNo(Contact_No.getText())) {
            System.out.println("Invalid contact number. Please enter a valid phone number.");
            return false;
        }
        if(Session.getRole()!= "admin"){
            System.out.println("You are not authorized to perform this action.");
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

    private static boolean isValidContactNo(String contactNo) {
        // Example: Regular expression validation for a 11-digit phone number
        String regex = "\\d{11}";
        return contactNo.matches(regex);
    }
}
