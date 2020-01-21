package com.epam.webapp.entity;

import java.util.Objects;

public class Exercise {
    public static final String EXERCISE_TABLE_NAME = "exercise_program";
    public static final String EXERCISE_ID_COLUMN_NAME = "id";
    public static final String EXERCISE_NAME_COLUMN_NAME = "exercise_name";
    public static final String FREQUENCY_COLUMN_NAME = "frequency";
    private long id;
    private String exercise_name;
    private String frequency;

    public Exercise(long id, String exercise_name, String frequency) {
        this.id = id;
        this.exercise_name = exercise_name;
        this.frequency = frequency;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExercise_name() {
        return exercise_name;
    }

    public void setExercise_name(String exercise_name) {
        this.exercise_name = exercise_name;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return id == exercise.id &&
                Objects.equals(exercise_name, exercise.exercise_name) &&
                Objects.equals(frequency, exercise.frequency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, exercise_name, frequency);
    }
}
