package com.hms.hms_dashboard_01.DTO;

public class WardenDTO {

    private String wardenName;
    private String wardenEmail;
    private String wardenContact;
    private int wardenId;
    private String gender;
    private String address;


    public String getWardenName() {
        return wardenName;
    }

    public void setWardenName(String wardenName) {
        this.wardenName = wardenName;
    }

    public String getWardenEmail() {
        return wardenEmail;
    }

    public void setWardenEmail(String wardenEmail) {
        this.wardenEmail = wardenEmail;
    }

    public String getWardenContact() {
        return wardenContact;
    }

    public void setWardenContact(String wardenContact) {
        this.wardenContact = wardenContact;
    }

    public int getWardenId() {
        return wardenId;
    }

    public void setWardenId(int wardenId) {
        this.wardenId = wardenId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
