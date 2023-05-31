package com.hms.hms_dashboard_01.model.registration;

import com.hms.hms_dashboard_01.model.entities.Student;

import java.util.ArrayList;

public class PendingRegistration {
//    Array list to hold the pending registrations of students, that can later be accessed and approved by the admin or the warden
//    Needs more work
    public static ArrayList<Student> pendingRegistrations = new ArrayList<>();
    public PendingRegistration(Student student) {
        pendingRegistrations.add(student);
    }
}
