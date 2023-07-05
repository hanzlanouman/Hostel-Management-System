package com.hms.hms_dashboard_01.utility;

public class Session {

    private static String role;

    public static String getRole() {
        return role;
    }



    public static void setRole(String role) {
        Session.role = role;
    }

    public Session(String role) {
        Session.role = role;
    }

    public static void destroySession() {
        Session.role = null;
    }

}
