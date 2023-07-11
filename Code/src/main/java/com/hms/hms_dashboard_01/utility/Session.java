//package com.hms.hms_dashboard_01.utility;
//public class Session {
//    Session (){
//    }
//    private static String role;
//    public static String getRole() {
//        return role;
//    }
//    public static void setRole(String role) {
//        Session.role = role;
//    }
//    public Session(String role) {
//        Session.role = role;
//    }
//    public static void destroySession() {
//        Session.role = null;
//    }}

package com.hms.hms_dashboard_01.utility;

import java.util.Timer;
import java.util.TimerTask;

public class Session {
    private static String role;
    private static Timer sessionTimer;

    static {
        sessionTimer = new Timer();
    }

    public static String getRole() {
        return role;
    }



    public static void setRole(String role) {
        Session.role = role;
    }

    public Session(String role) {
        Session.role = role;
        startSessionTimer();
    }

    public static void destroySession() {
        Session.role = null;
        stopSessionTimer();
    }

    private static void startSessionTimer() {
        final long sessionTimeout = 1 * 60 * 1000; // 30 minutes (adjust as needed)
        sessionTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                destroySession();
                System.out.println("Session expired due to inactivity.");
            }
        }, sessionTimeout);
    }

    private static void stopSessionTimer() {
        sessionTimer.cancel();
    }
}

