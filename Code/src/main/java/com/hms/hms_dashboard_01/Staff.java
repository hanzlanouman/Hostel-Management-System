package com.hms.hms_dashboard_01;

public class Staff {
    private int staffId;
    private String staffRole;
    private String staffName;
    private String staffContact;
    private String staffEmail;
    private String staffUsername;
    private String staffPassword;

//    Write constructor
    public Staff(int staffId, String staffName, String staffContact, String staffEmail, String staffUsername, String staffPassword, String staffRole) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.staffContact = staffContact;
        this.staffEmail = staffEmail;
        this.staffUsername = staffUsername;
        this.staffPassword = staffPassword;
        this.staffRole = staffRole;
    }
    public Staff(int staffId, String staffName, String staffRole, String staffContact, String staffEmail) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.staffContact = staffContact;
        this.staffEmail = staffEmail;
        this.staffRole = staffRole;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffContact() {
        return staffContact;
    }

    public void setStaffContact(String staffContact) {
        this.staffContact = staffContact;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getStaffUsername() {
        return staffUsername;
    }

    public void setStaffUsername(String staffUsername) {
        this.staffUsername = staffUsername;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    public String getStaffRole() {
        return staffRole;
    }
    public void setStaffRole(String staffRole){
        this.staffRole = staffRole;
    }
}
