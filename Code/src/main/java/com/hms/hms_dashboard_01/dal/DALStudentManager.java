package com.hms.hms_dashboard_01.dal;

import com.hms.hms_dashboard_01.DTO.StudentDTO;
import com.hms.hms_dashboard_01.model.entities.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DALStudentManager {
    static Connection conn = DatabaseConnection.getConnection();

    public static void addStudent(StudentDTO student) {
        String query = "INSERT INTO Student (studentUsername, studentId, studentEmail, studentContact, studentAddress, studentPassword, studentName, rollNo, year, roomNo, roomType, roomPrice, roomStatus) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, student.getStudentUsername());
            pstmt.setInt(2, student.getStudentId());
            pstmt.setString(3, student.getStudentEmail());
            pstmt.setString(4, student.getStudentContact());
            pstmt.setString(5, student.getStudentAddress());
            pstmt.setString(6, student.getStudentPassword());
            pstmt.setString(7, student.getStudentName());
            pstmt.setString(8, student.getRollNo());
            pstmt.setString(9, student.getYear());
            pstmt.setString(10, student.getRoomNo());
            pstmt.setString(11, student.getRoomType());
            pstmt.setString(12, student.getRoomPrice());
            pstmt.setString(13, student.getRoomStatus());

            pstmt.executeUpdate();

            System.out.println("Data has been inserted into Students table.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    public static void deleteStudent(int studentId) {

        try {
            Statement stmt = conn.createStatement();
            String query = "DELETE FROM Student WHERE studentId = " + studentId;

            stmt.executeUpdate(query);

            System.out.println("Data has been deleted from Student table.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM Student";

            var rs = stmt.executeQuery(query);

            while (rs.next()) {
                Student student = new Student();
                student.setStudentUsername(rs.getString("studentUsername"));
                student.setStudentId(rs.getInt("studentId"));
                student.setStudentEmail(rs.getString("studentEmail"));
                student.setStudentContact(rs.getString("studentContact"));
                student.setStudentAddress(rs.getString("studentAddress"));
                student.setStudentPassword(rs.getString("studentPassword"));
                student.setStudentName(rs.getString("studentName"));
                student.setRollNo(rs.getString("rollNo"));
                student.setYear(rs.getString("year"));
                student.setRoomNo(rs.getString("roomNo"));
                student.setRoomType(rs.getString("roomType"));
                student.setRoomPrice(rs.getString("roomPrice"));
                student.setRoomStatus(rs.getString("roomStatus"));

                students.add(student);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return students;
    }


}
