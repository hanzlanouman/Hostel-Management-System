package com.hms.hms_dashboard_01.controllers;

import com.hms.hms_dashboard_01.DTO.StudentDTO;
import com.hms.hms_dashboard_01.dal.DALStudentManager;
import com.hms.hms_dashboard_01.model.entities.Student;

import java.util.List;

public class StudentController {

    public static void addStudent(StudentDTO student){
        DALStudentManager.addStudent(student);
    }
    public static void deleteStudent(int studentId){
        DALStudentManager.deleteStudent(studentId);
    }

    public static List<Student> getAllStudents(){
        return DALStudentManager.getAllStudents();
    }
}
