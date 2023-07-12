package com.hms.hms_dashboard_01.Validators;

import com.hms.hms_dashboard_01.DTO.StudentDTO;
import com.hms.hms_dashboard_01.utility.Session;

public class StudentFormValidator {

    public static String validateFields(StudentDTO student) {
        if (student.getRollNo().isEmpty() || student.getStudentName().isEmpty() || student.getStudentContact().isEmpty()
                || student.getEmail().isEmpty() || student.getAddress().isEmpty()){
            return "Please fill in all fields.";
        }

        // Additional validation logic
        if (!isNumeric(student.getRollNo())) {
            return "ID must be a numeric value.";
        }

        if (!isValidContactNo(student.getStudentContact())) {
            return "Invalid contact number. Please enter a valid phone number.";
        }
//        if(Session.getRole()!= "warden"){
//            return "You are not authorized to perform this action.";
//        }

        return null; // Indicates no validation errors
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
        // Example: Regular expression validation for an 11-digit phone number
        String regex = "\\d{11}";
        return contactNo.matches(regex);
    }
}
