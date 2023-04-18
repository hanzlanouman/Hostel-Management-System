package com.hms.hms_dashboard_01;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class PendingRegistrationController {

    static ObservableList<Student> pendingRegistrations;
    public static void setPendingRegistrations(ArrayList<Student> pendingRegistrations) {
        pendingRegistrations = PendingRegistration.pendingRegistrations;
    }

    public static ObservableList<Student> getPendingRegistrations() {
        return pendingRegistrations;
    }

}
