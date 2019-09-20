package com.example.healthinfo;

public class Details {
    private String title, location, contact;

    public Details() {
    }

    public Details(String title, String location, String contact) {
        this.title = title;
        this.location = location;
        this.contact = contact;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String year) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String genre) {
        this.contact = contact;
    }
}

