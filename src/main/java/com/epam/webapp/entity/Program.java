package com.epam.webapp.entity;

import java.util.Date;
import java.util.Objects;

public class Program {
    private Long id;
    private Long userId;
    private Diet diet;
    private Date validTo;
    ProgramStatus status;

    public Program(Long id, Long userId, Diet diet, Date validTo, ProgramStatus status) {
        this.id = id;
        this.userId = userId;
        this.diet = diet;
        this.validTo = validTo;
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
                diet == program.diet &&
                Objects.equals(validTo, program.validTo) &&
                status == program.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, diet, validTo, status);
    }

    @Override
    public String toString() {
        return "Program{" +
                "id=" + id +
                ", userId=" + userId +
                ", diet=" + diet +
                ", validTo=" + validTo +
                ", status=" + status +
                '}';
    }
}
