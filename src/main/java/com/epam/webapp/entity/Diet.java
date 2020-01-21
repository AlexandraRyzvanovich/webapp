package com.epam.webapp.entity;

import java.util.Objects;

public class Diet {
    public static final String DIET_TABLE_NAME = "diet_program";
    public static final String FOOD_TYPE_COLUMN_NAME = "food_type";
    public static final String DESCRIPTION_COLUMN_NAME = "description";
    private long id;
    private String foodType;
    private String description;

    public Diet(int id, String foodType, String description) {
        this.id = id;
        this.foodType = foodType;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diet diet = (Diet) o;
        return id == diet.id &&
                Objects.equals(foodType, diet.foodType) &&
                Objects.equals(description, diet.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, foodType, description);
    }
}
