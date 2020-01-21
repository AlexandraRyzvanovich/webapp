package com.epam.webapp.entity;

import java.util.Date;
import java.util.Objects;

public class Program implements Identifiable {
    public static final String PROGRAM_TABLE_NAME = "program";
    public static final String USER_ID_COLUMN_NAME = "user_id";
    public static final String EXERCISE_COLUMN_NAME = "exercise_id";
    public static final String DIET_COLUMN_NAME = "diet_id";
    public static final String VALID_TO_COLUMN_NAME = "valid_to";
    public static final String STATUS_COLUMN_NAME = "status";
    private long id;
    private long userId;
    Exercise exercise;
    Diet diet;
    Date validTo;
    ProgramStatus status;


    public Program(long id, long userId, Exercise exercise, Diet diet, ProgramStatus status, Date validTo) {
        this.id = id;
        this.userId = userId;
        this.exercise = exercise;
        this.diet = diet;
        this.status = status;
        this.validTo = validTo;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Diet getDiet() {
        return diet;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public ProgramStatus getStatus() {
        return status;
    }

    public void setStatus(ProgramStatus status) {
        this.status = status;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Program program = (Program) o;
        return id == program.id &&
                userId == program.userId &&
                Objects.equals(exercise, program.exercise) &&
                Objects.equals(diet, program.diet) &&
                status == program.status &&
                Objects.equals(validTo, program.validTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, exercise, diet, status, validTo);
    }
}
