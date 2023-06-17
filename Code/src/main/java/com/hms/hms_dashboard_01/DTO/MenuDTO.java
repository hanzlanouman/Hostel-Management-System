package com.hms.hms_dashboard_01.DTO;

public class MenuDTO {

    private String Breakfast;
    private String Lunch;
    private String Dinner;
    private String Day;

    public MenuDTO(String Breakfast, String Lunch, String Dinner, String Day) {
        this.Day = Day;
        this.Breakfast = Breakfast;
        this.Lunch = Lunch;
        this.Dinner = Dinner;

    }

public MenuDTO(){};
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
