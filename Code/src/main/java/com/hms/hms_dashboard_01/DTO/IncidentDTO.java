package com.hms.hms_dashboard_01.DTO;

public class IncidentDTO {

    //    private String IncidentType;
    private Integer IncidentId;
    private String Date;
    private String Time;
    private String Day;
    private String Location;
    private String Description;

    public IncidentDTO(Integer IncidentId, String Date, String Day, String Location, String Description, String Time) {
        this.IncidentId=IncidentId;
        this.Date = Date;
        this.Day = Day;
        this.Location = Location;
        this.Description = Description;
        this.Time = Time;

    }
    public IncidentDTO(){};
    public void setIncidentId(Integer IncidentId ) {
        this.IncidentId = IncidentId;
    }
    public Integer getIncidentId() {
        return IncidentId;
    }
    public void setDate(String Date) {
        this.Date = Date;
    }
    public String getDate() {
        return Date;
    }
    public void setDay(String Day) {
        this.Day = Day;
    }
    public String getDay() {
        return Day;
    }
    public void setLocation(String Location) {
        this.Location = Location;
    }
    public String getLocation() {
        return Location;
    }
    public String getTime() {
        return Time;
    }
    public void setTime(String Time) {
        this.Time = Time;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String Description) {
        this.Description = Description;
    }
}
