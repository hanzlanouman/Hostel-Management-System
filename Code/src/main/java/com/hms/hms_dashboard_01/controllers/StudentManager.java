package com.hms.hms_dashboard_01.controllers;

import com.hms.hms_dashboard_01.DTO.StudentDTO;
import com.hms.hms_dashboard_01.dal.DALStudentManager;

public class StudentManager {

    public static void addStudent(StudentDTO student){
        DALStudentManager.addStudent(student);
    }
    public static void deleteStudent(int studentId){
        DALStudentManager.deleteStudent(studentId);
    }
}
