package com.hms.hms_dashboard_01.controllers;

import com.hms.hms_dashboard_01.DTO.StudentDTO;
import com.hms.hms_dashboard_01.Factory.HMSFactory;
import com.hms.hms_dashboard_01.Validators.StudentFormValidator;
import com.hms.hms_dashboard_01.dal.DALIncidentManager;
import com.hms.hms_dashboard_01.dal.DALStudentManager;
import com.hms.hms_dashboard_01.model.entities.Student;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.List;

public class  StudentController {

    public String addStudent(StudentDTO studentDTO){

        String validationError = StudentFormValidator.validateFields(studentDTO);
        if(validationError == null){
            DALStudentManager dalStudentManager = HMSFactory.getInstanceOfStudentManager();
            dalStudentManager.addStudent(studentDTO);
            return null;
        }
//        DALStudentManager.addStudent(student);
        return validationError;
    }
    public  void deleteStudent(int studentId){

        DALStudentManager dalStudentManager = HMSFactory.getInstanceOfStudentManager();
        dalStudentManager.deleteStudent(studentId);
    }

    public  List<Student> getAllStudents(){

        DALStudentManager dalStudentManager = HMSFactory.getInstanceOfStudentManager();
        return dalStudentManager.getAllStudents();
    }
}
