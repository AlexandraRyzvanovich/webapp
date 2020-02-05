package com.epam.webapp.dto;

import com.epam.webapp.entity.Identifiable;
import com.epam.webapp.entity.ProgramStatus;

import java.util.Objects;

public class InternCard implements Identifiable {
    public static final String INTERN_TABLE_NAME_FOR_MAPPER = "interns";

    private Long userId;
    private String firstName;
    private String lastName;
    private String exerciseDescription;
    private String exerciseList;
    private String dietDescription;
    private String foodList;
    private String additionalInfo;
    ProgramStatus status;

    public InternCard(Long userId, String firstName, String lastName, String exerciseDescription, String exerciseList, String dietDescription, String foodList, String additionalInfo, ProgramStatus status) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.exerciseDescription = exerciseDescription;
        this.exerciseList = exerciseList;
        this.dietDescription = dietDescription;
        this.foodList = foodList;
        this.additionalInfo = additionalInfo;
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getExerciseDescription() {
        return exerciseDescription;
    }

    public void setExerciseDescription(String exerciseDescription) {
        this.exerciseDescription = exerciseDescription;
    }

    public String getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(String exerciseList) {
        this.exerciseList = exerciseList;
    }

    public String getDietDescription() {
        return dietDescription;
    }

    public void setDietDescription(String dietDescription) {
        this.dietDescription = dietDescription;
    }

    public String getFoodList() {
        return foodList;
    }

    public void setFoodList(String foodList) {
        this.foodList = foodList;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public ProgramStatus getStatus() {
        return status;
    }

    public void setStatus(ProgramStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InternCard that = (InternCard) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(exerciseDescription, that.exerciseDescription) &&
                Objects.equals(exerciseList, that.exerciseList) &&
                Objects.equals(dietDescription, that.dietDescription) &&
                Objects.equals(foodList, that.foodList) &&
                Objects.equals(additionalInfo, that.additionalInfo) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, exerciseDescription, exerciseList, dietDescription, foodList, additionalInfo, status);
    }

    @Override
    public String toString() {
        return "InternCard{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", exerciseDescription='" + exerciseDescription + '\'' +
                ", exerciseList='" + exerciseList + '\'' +
                ", dietDescription='" + dietDescription + '\'' +
                ", foodList='" + foodList + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", status=" + status +
                '}';
    }
}
