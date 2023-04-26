package com.hms.hms_dashboard_01;

public class Warden {
    private String wardenName;
    private String wardenEmail;
    private String wardenContact;
    private int wardenId;

    public Warden(String wardenName, String wardenEmail, String wardenContact, int wardenId) {
        this.wardenName = wardenName;
        this.wardenEmail = wardenEmail;
        this.wardenContact = wardenContact;
        this.wardenId = wardenId;
    }
//    write set and get methods

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
}
