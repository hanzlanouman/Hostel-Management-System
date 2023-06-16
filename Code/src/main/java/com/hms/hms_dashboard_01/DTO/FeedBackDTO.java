package com.hms.hms_dashboard_01.DTO;

public class FeedBackDTO {



    private String stu_Name;
    private String Contact_No;
    private String Feed_Sub;
    private String Feed_category;
    private int Stu_ID;
    private String feed_Des;
    private  int Room_No;

    public FeedBackDTO(String stu_Name, String Contact_No, String Feed_Sub, String Feed_category, int Stu_ID, String feed_Des,int Room_No) {
        this.stu_Name = stu_Name;
        this.Contact_No = Contact_No;
        this.Feed_Sub = Feed_Sub;
        this.Feed_category = Feed_category;
        this.Stu_ID = Stu_ID;
        this.feed_Des = feed_Des;
        this.Room_No = Room_No;
    }
    public FeedBackDTO(){};
    public void setstu_Name(String stu_Name) {
        this.stu_Name = stu_Name;
    }
    public String getstu_Name() {
        return stu_Name;
    }
    public void setContact_No(String Contact_No) {
        this.Contact_No = Contact_No;
    }
    public String getContact_No() {
        return Contact_No;
    }
    public void setFeed_Sub(String Feed_Sub) {
        this.Feed_Sub = Feed_Sub;
    }
    public String getFeed_Sub() {
        return Feed_Sub;
    }
    public String getFeed_category() {
        return Feed_category;
    }
    public void setFeed_category(String Feed_category) {
        this.Feed_category = Feed_category;
    }
    public int getStu_ID() {
        return Stu_ID;
    }
    public void setStu_ID(int Stu_ID) {
        this.Stu_ID = Stu_ID;
    }
    public int getRoom_No() {
        return Room_No;
    }
    public void setRoom_No(int Room_No) {
        this.Room_No = Room_No;
    }
    public String getfeed_Des() {
        return feed_Des;
    }
    public void setfeed_Des(String feed_Des) {
        this.feed_Des = feed_Des;
    }

}
