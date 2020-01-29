package com.epam.webapp.entity;

import java.util.Date;
import java.util.Objects;

public class Program implements Identifiable {
    public static final String PROGRAM_TABLE_NAME = "program";
    public static final String USER_ID_COLUMN_NAME = "user_id";
    public static final String EXERCISE_DESCRIPTION_COLUMN_NAME = "exercise_description";
    public static final String EXERCISE_LIST_COLUMN_NAME = "exercise_list";
    public static final String DIET_DESCRIPTION_COLUMN_NAME = "diet_description";
    public static final String FOOD_LIST_COLUMN_NAME = "food_list";
    public static final String ADDITIONAL_INFO_COLUMN_NAME = "additional_info";
    public static final String VALID_TO_COLUMN_NAME = "valid_to";
    public static final String STATUS_COLUMN_NAME = "status";

    private Long id;
    private Long userId;
    private String exerciseDescription;
    private String[] exerciseList;
    private String dietDescription;
    private String[] foodList;
    private String additionalInfo;
    private Date validTo;
    ProgramStatus status;

    public Program(Long id, Long userId, String exerciseDescription, String[]  exerciseList, String dietDescription, String[]  foodList, String additionalInfo, Date validTo, ProgramStatus status) {
        this.id = id;
        this.userId = userId;
        this.exerciseDescription = exerciseDescription;
        this.exerciseList = exerciseList;
        this.dietDescription = dietDescription;
        this.foodList = foodList;
        this.additionalInfo = additionalInfo;
        this.validTo = validTo;
        this.status = status;
    }
    public Program(Long userId, String exerciseDescription, String[]  exerciseList, String dietDescription, String[]  foodList, String additionalInfo, ProgramStatus status) {
        this.userId = userId;
        this.exerciseDescription = exerciseDescription;
        this.exerciseList = exerciseList;
        this.dietDescription = dietDescription;
        this.foodList = foodList;
        this.additionalInfo = additionalInfo;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getExerciseDescription() {
        return exerciseDescription;
    }

    public void setExerciseDescription(String exerciseDescription) {
        this.exerciseDescription = exerciseDescription;
    }

    public String[]  getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(String[]  exerciseList) {
        this.exerciseList = exerciseList;
    }

    public String getDietDescription() {
        return dietDescription;
    }

    public void setDietDescription(String dietDescription) {
        this.dietDescription = dietDescription;
    }

    public String[]  getFoodList() {
        return foodList;
    }

    public void setFoodList(String[]  foodList) {
        this.foodList = foodList;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
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
        Program program = (Program) o;
        return Objects.equals(id, program.id) &&
                Objects.equals(userId, program.userId) &&
                Objects.equals(exerciseDescription, program.exerciseDescription) &&
                Objects.equals(exerciseList, program.exerciseList) &&
                Objects.equals(dietDescription, program.dietDescription) &&
                Objects.equals(foodList, program.foodList) &&
                Objects.equals(additionalInfo, program.additionalInfo) &&
                Objects.equals(validTo, program.validTo) &&
                status == program.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, exerciseDescription, exerciseList, dietDescription, foodList, additionalInfo, validTo, status);
    }

    @Override
    public String toString() {
        return "Program{" +
                "id=" + id +
                ", userId=" + userId +
                ", exerciseDescription='" + exerciseDescription + '\'' +
                ", exerciseList='" + exerciseList + '\'' +
                ", dietDescription='" + dietDescription + '\'' +
                ", foodList='" + foodList + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", validTo=" + validTo +
                ", status=" + status +
                '}';
    }
}