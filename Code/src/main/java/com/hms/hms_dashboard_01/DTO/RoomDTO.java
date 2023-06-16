package com.hms.hms_dashboard_01.DTO;

public class RoomDTO {
    private int roomNo;

    private String roomType;
    private String roomCapacity;

    private String roomFloor;

    private String roomAvb;

    private String roomStatus;
    private int roomFee;
    private String roomAssignedTo;
    private String roomBuilding;


    public RoomDTO(int roomNo, String roomStatus, int roomFee, String roomAssignedTo, String roomBuilding) {
        this.roomNo = roomNo;
        this.roomStatus = roomStatus;
        this.roomFee = roomFee;
        this.roomAssignedTo = roomAssignedTo;
        this.roomBuilding = roomBuilding;
    }

    public RoomDTO(){};
//    Write setters and getters

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

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

    public String getRoomBuilding() {
        return roomBuilding;
    }

    public void setRoomBuilding(String roomLocation) {
        this.roomBuilding = roomBuilding;
    }

    public void setRoomAvb(String roomAvb) {
        this.roomAvb = roomAvb;
    }

    public String getRoomAvb() {
        return roomAvb;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    public String getRoomType() {
        return roomType;
    }

    public void setRoomCapacity(String roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public String getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomFloor(String roomFloor) {
        this.roomFloor = roomFloor;
    }

    public String getRoomFloor() {
        return roomFloor;
    }


}
