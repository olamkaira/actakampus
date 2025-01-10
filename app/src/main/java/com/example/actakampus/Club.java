package com.example.actakampus;

public class Club {
    private String name;
    private String description;
    private String category;
    private int memberCount;

    public Club(String name, String description, String category, int memberCount) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.memberCount = memberCount;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public int getMemberCount() {
        return memberCount;
    }
} 