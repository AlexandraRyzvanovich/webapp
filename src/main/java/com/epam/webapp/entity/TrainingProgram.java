package com.epam.webapp.entity;

import java.util.Objects;

public class TrainingProgram implements Identifiable {
    public static final String TABLE_NAME = "training_program";
    public static final String ID_COLUMN_NAME = "id";
    public static final String PROGRAM_ID_COLUMN_NAME = "program_id";
    public static final String EXERCISE_ID_COLUMN_NAME = "exercise_id";
    public static final String FREQUENCY_COLUMN_NAME = "frequency";

    private Long id;
    private Long programId;
    private Long exerciseId;
    private Integer frequency;

    public TrainingProgram(Long id, Long programId, Long exerciseId, Integer frequency) {
        this.id = id;
        this.programId = programId;
        this.exerciseId = exerciseId;
        this.frequency = frequency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
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
        TrainingProgram that = (TrainingProgram) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(programId, that.programId) &&
                Objects.equals(exerciseId, that.exerciseId) &&
                Objects.equals(frequency, that.frequency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, programId, exerciseId, frequency);
    }

    @Override
    public String toString() {
        return "TrainingProgram{" +
                "id=" + id +
                ", programId=" + programId +
                ", exerciseId=" + exerciseId +
                ", frequency=" + frequency +
                '}';
    }
}