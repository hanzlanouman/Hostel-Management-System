package com.hms.hms_dashboard_01;

public class Security extends Staff{
//
    public Security(int staffId, String staffName, String staffContact, String staffEmail, String staffUsername, String staffPassword, String staffRole) {
        super(staffId, staffName, staffContact, staffEmail, staffUsername, staffPassword, staffRole);
    }
    public Security(int staffId, String staffName, String staffRole, String staffContact, String staffEmail) {
        super(staffId, staffName, staffRole, staffContact, staffEmail);
    }
}
