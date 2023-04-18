package com.hms.hms_dashboard_01;

import java.util.ArrayList;

public class PendingRegistration {
//    Make an ArrayList of PendingRegistration objects static
    public static ArrayList<Student> pendingRegistrations = new ArrayList<>();
    public PendingRegistration(Student student) {
        pendingRegistrations.add(student);
    }
}
