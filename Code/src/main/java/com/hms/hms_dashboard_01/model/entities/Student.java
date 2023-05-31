package com.hms.hms_dashboard_01.model.entities;

public class Student {
    private String studentUsername;
    private int studentId;
    private String studentEmail;
    private String studentContact;
    private String studentPassword;
    private String studentName;
    private String rollNo;
    private String year;
    private String roomNo;
    private String roomType;
    private String roomPrice;
    private String roomStatus;

    public Student(String studentName, String rollNo, String branch, String year, String roomNo, String roomType, String roomPrice, String roomStatus) {
        this.studentName = studentName;
        this.rollNo = rollNo;
        this.year = year;
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.roomStatus = roomStatus;
    }

    public Student(String studentUsername, String studentPassword) {
        this.studentUsername = studentUsername;
        this.studentPassword = studentPassword;
    }
    public Student(int studentId,String studentName, String studentContact,String studentEmail){
        this.studentId = studentId;
        this.studentEmail = studentEmail;
        this.studentName =studentName;
        this.studentContact = studentContact;
    }


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(String roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }


//    write get methods for username and password
    public String getStudentUsername() {
        return studentUsername;
    }

    public String getStudentPassword() {
        return studentPassword;
    }
    public String getStudentEmail() {
        return studentEmail;
    }
    public String getStudentContact() {
        return studentContact;
    }
    public int getStudentId() {
        return studentId;
    }
    public void setStudentUsername(String studentUsername) {
        this.studentUsername = studentUsername;
    }
    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }
    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }
    public void setStudentContact(String studentContact) {
        this.studentContact = studentContact;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
