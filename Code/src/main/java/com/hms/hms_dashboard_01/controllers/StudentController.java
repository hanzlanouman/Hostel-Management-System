package com.hms.hms_dashboard_01.controllers;

import com.hms.hms_dashboard_01.DTO.StudentDTO;
import com.hms.hms_dashboard_01.Factory.HMSFactory;
import com.hms.hms_dashboard_01.Validators.StudentFormValidator;
import com.hms.hms_dashboard_01.dal.DALStudentManager;
import com.hms.hms_dashboard_01.model.entities.Student;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.List;

public class StudentController {

    public static String addStudent(String id, String studentName, String email, String address, String contact){

        StudentDTO studentDTO = HMSFactory.getInstanceOfStudent();
        studentDTO.setRollNo((id));
        studentDTO.setStudentName(studentName);
        studentDTO.setEmail(email);
        studentDTO.setAddress(address);
        studentDTO.setStudentContact(contact);


        String validationError = StudentFormValidator.validateFields(studentDTO);
        if(validationError == null){
            DALStudentManager.addStudent(studentDTO);
            return null;
        }
//        DALStudentManager.addStudent(student);
        return validationError;
    }
    public static void deleteStudent(int studentId){
        DALStudentManager.deleteStudent(studentId);
    }

    public static List<Student> getAllStudents(){
        return DALStudentManager.getAllStudents();
    }
}
