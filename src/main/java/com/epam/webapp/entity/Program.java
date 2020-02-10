package com.epam.webapp.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Program implements Identifiable {
    public static final String TABLE_NAME = "program";
    public static final String ID_COLUMN_NAME = "id";
    public static final String USER_ID_COLUMN_NAME = "user_id";
    public static final String DIET_COLUMN_NAME = "diet";
    public static final String START_DATE_COLUMN_NAME = "start_date";
    public static final String END_DATE_COLUMN_NAME = "end_date";
    public static final String STATUS_COLUMN_NAME = "status";

    private Long id;
    private Long userId;
    private Diet diet;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    ProgramStatus status;

    public Program(Long id, Long userId, Diet diet, LocalDateTime startDate, LocalDateTime endDate, ProgramStatus status) {
        this.id = id;
        this.userId = userId;
        this.diet = diet;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Diet getDiet() {
        return diet;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
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
                diet == program.diet &&
                Objects.equals(startDate, program.startDate) &&
                Objects.equals(endDate, program.endDate) &&
                status == program.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, diet, startDate, endDate, status);
    }

    @Override
    public String toString() {
        return "Program{" +
                "id=" + id +
                ", userId=" + userId +
                ", diet=" + diet +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                '}';
    }
}
