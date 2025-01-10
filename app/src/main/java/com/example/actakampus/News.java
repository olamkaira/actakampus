package com.example.actakampus;

public class News {
    private String title;
    private String content;
    private String date;
    private String category;
    private String imageUrl;

    public News(String title, String content, String date, String category, String imageUrl) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.category = category;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public String getImageUrl() {
        return imageUrl;
    }
} 