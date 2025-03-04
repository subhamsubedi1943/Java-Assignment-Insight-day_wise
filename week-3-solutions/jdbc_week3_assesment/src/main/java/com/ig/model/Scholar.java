package com.ig.model;

public class Scholar {
    private int scholarId;
    private String name;
    private String email;
    private String mobile;

    public Scholar() {}

    public Scholar(int scholarId, String name, String email, String mobile) {
        this.scholarId = scholarId;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public int getScholarId() { return scholarId; }
    public void setScholarId(int scholarId) { this.scholarId = scholarId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    @Override
    public String toString() {
        return "Scholar{Id=" + scholarId + ", Name='" + name + "', Email='" + email + "', Mobile='" + mobile + "'}";
    }
}
