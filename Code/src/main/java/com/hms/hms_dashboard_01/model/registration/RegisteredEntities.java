package com.hms.hms_dashboard_01.model.registration;

import com.hms.hms_dashboard_01.model.entities.Student;

import java.util.ArrayList;

public class RegisteredEntities {
//Array list that hold the registered students (students approved by the admin or the warden)
//    Can also have a list of students that are not approved by the admin or the warden
//    Can also have all the employees, staff, wardens etc., that are registered in the system
    public static ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getStudents() {
        return students;
    }

}
