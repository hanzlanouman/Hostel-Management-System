package com.hms.hms_dashboard_01.DTO;

public class MenuDTO {
        private Integer MenuID;

    private String Breakfast;
    private String Lunch;
    private String Dinner;
    private String Day;

    public MenuDTO(Integer MenuID, String Breakfast, String Lunch, String Dinner, String Day) {
        this.MenuID = MenuID;
        this.Day = Day;
        this.Breakfast = Breakfast;
        this.Lunch = Lunch;
        this.Dinner = Dinner;

    }

public MenuDTO(){};
    public void setMenuID(Integer MenuID) {
        this.MenuID = MenuID;
    }
    public Integer getMenuID() {
        return MenuID;
    }
    public void setDay(String Day) {
        this.Day = Day;
    }
    public String getDay() {
        return Day;
    }
    public void setBreakfast(String Breakfast) {
        this.Breakfast = Breakfast;
    }
    public String getBreakfast() {
        return Breakfast;
    }
    public String getDinner() {
        return Dinner;
    }
    public void setDinner(String Dinner) {
        this.Dinner = Dinner;
    }
    public String getLunch() {
        return Lunch;
    }
    public void setLunch(String Lunch) {
        this.Lunch = Lunch;
    }
}
