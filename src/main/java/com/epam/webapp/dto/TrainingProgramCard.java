package com.epam.webapp.dto;

import com.epam.webapp.entity.Identifiable;

import java.util.Objects;

public class TrainingProgramCard implements Identifiable {
    public static final String TABLE_NAME_DTO = "training_program_card";
    public static final String PROGRAM_ID_COLUMN_NAME = "program_id";
    public static final String EXERCISE_COLUMN_NAME = "name";
    public static final String FREQUENCY_COLUMN_NAME = "frequency";

    private Long programId;
    private String exercise;
    private Integer frequency;

    public TrainingProgramCard(Long programId, String exercise, Integer frequency) {
        this.programId = programId;
        this.exercise = exercise;
        this.frequency = frequency;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainingProgramCard that = (TrainingProgramCard) o;
        return Objects.equals(programId, that.programId) &&
                Objects.equals(exercise, that.exercise) &&
                Objects.equals(frequency, that.frequency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(programId, exercise, frequency);
    }

    @Override
    public String toString() {
        return "TrainingProgramCard{" +
                "programId=" + programId +
                ", exercise='" + exercise + '\'' +
                ", frequency=" + frequency +
                '}';
    }
}
