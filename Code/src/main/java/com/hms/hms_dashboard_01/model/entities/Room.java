package com.hms.hms_dashboard_01.model.entities;

public class Room {
    private int roomNo;
//    private String roomType;
    private String roomStatus;
    private int roomFee;
    private String roomAssignedTo;
    private String roomLocation;

    public Room(int roomNo, String roomStatus, int roomFee, String roomAssignedTo, String roomLocation) {
        this.roomNo = roomNo;
        this.roomStatus = roomStatus;
        this.roomFee = roomFee;
        this.roomAssignedTo = roomAssignedTo;
        this.roomLocation = roomLocation;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

//    public String getRoomType() {
//        return roomType;
//    }

//    public void setRoomType(String roomType) {
//        this.roomType = roomType;
//    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public int getRoomFee() {
        return roomFee;
    }

    public void setRoomFee(int roomFee) {
        this.roomFee = roomFee;
    }

    public String getRoomAssignedTo() {
        return roomAssignedTo;
    }

    public void setRoomAssignedTo(String roomAssignedTo) {
        this.roomAssignedTo = roomAssignedTo;
    }

    public String getRoomLocation() {
        return roomLocation;
    }

    public void setRoomLocation(String roomLocation) {
        this.roomLocation = roomLocation;
    }


}
