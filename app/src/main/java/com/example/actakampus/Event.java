package com.example.actakampus;

public class Event {
    private String title;
    private String description;
    private String date;
    private String location;
    private String category;

    public Event(String title, String description, String date, String location, String category) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.location = location;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getCategory() {
        return category;
    }
} 