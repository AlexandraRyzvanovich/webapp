package com.epam.webapp.entity;

import java.util.Objects;

public class Diet {
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

    public void setId(int id) {
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
