package com.hms.hms_dashboard_01.DTO;

public class StudentDTO {
    private String studentUsername;
    private int studentId;
    private String studentEmail;
    private String studentContact;
    private String studentAdress;
    private String studentPassword;
    private String studentName;
    private String rollNo;
    private String year;
    private String roomNo;
    private String roomType;
    private String roomPrice;
    private String roomStatus;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public String getEmail() {
        return studentEmail;
    }

    public void setEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }



    public String getAddress() {
        return studentAdress;
    }

    public void setAddress(String studentAdress) {
        this.studentAdress = studentAdress;
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
}
