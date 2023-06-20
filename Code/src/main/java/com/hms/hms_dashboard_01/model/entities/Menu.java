package com.hms.hms_dashboard_01.model.entities;

public class Menu {


    //    private String IncidentType;
    private Integer MenuID;
    private String Day;

    private String Breakfast;
    private String Lunch;
    private String Dinner;

    public Menu(Integer MenuID , String Day, String Breakfast, String Lunch, String Dinner) {
        this.MenuID = MenuID;
        this.Day = Day;
        this.Breakfast = Breakfast;
        this.Lunch = Lunch;
        this.Dinner = Dinner;

    }

    public void setMenuID(Integer MenuID) {
        this.MenuID = MenuID;
    }
    public Integer getMenuID() {
        return MenuID;
    }
    public void setDay(String Date) {
        this.Day = Day;
    }
    public String getDay() {
        return Day;
    }
    public void setBreakfast(String Location) {
        this.Breakfast = Breakfast;
    }
    public String getBreakfast() {
        return Breakfast;
    }
    public String getDinner() {
        return Dinner;
    }
    public void setDinner(String Time) {
        this.Dinner = Dinner;
    }
    public String getLunch() {
        return Lunch;
    }
    public void setLunch(String Lunch) {
        this.Lunch = Lunch;
    }


}
