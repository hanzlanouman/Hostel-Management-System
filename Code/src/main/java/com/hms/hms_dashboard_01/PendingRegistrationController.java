package com.hms.hms_dashboard_01;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class PendingRegistrationController {
//Doesnt really work right now but will be used to display the pending registrations of students in the pending registration tab to the admin/warden

    static ObservableList<Student> pendingRegistrations;
    public static void setPendingRegistrations(ArrayList<Student> pendingRegistrations) {
        pendingRegistrations = PendingRegistration.pendingRegistrations;
    }

    public static ObservableList<Student> getPendingRegistrations() {
        return pendingRegistrations;
    }

}
