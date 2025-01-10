package com.example.actakampus;

public class FoodMenuItem {
    private String name;
    private String category;
    private String calories;

    public FoodMenuItem(String name, String category, String calories) {
        this.name = name;
        this.category = category;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getCalories() {
        return calories;
    }
} 