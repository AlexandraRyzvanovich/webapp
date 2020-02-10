package com.epam.webapp.dto;

import com.epam.webapp.entity.Identifiable;

import java.util.Objects;

public class Client implements Identifiable {
    public static final String TABLE_NAME = "clients";
    public static final String ID_COLUMN_NAME = "id";
    public static final String FIRST_NAME_COLUMN_NAME = "first_name";
    public static final String LAST_NAME_COLUMN_NAME = "last_name";
    public static final String EMAIL_COLUMN_NAME = "email";
    public static final String TRAINER_ID_COLUMN_NAME = "trainer_id";
    public static final String TRAINER_NAME_COLUMN_NAME = "trainer_id";
    public static final String BONUS_COLUMN_NAME = "bonus";

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long trainerId;
    private String trainerName;
    private Integer bonus;

    public Client(Long id, String firstName, String lastName, String email, Long trainerId, String trainerName, Integer bonus) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.trainerId = trainerId;
        this.trainerName = trainerName;
        this.bonus = bonus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(firstName, client.firstName) &&
                Objects.equals(lastName, client.lastName) &&
                Objects.equals(email, client.email) &&
                Objects.equals(trainerId, client.trainerId) &&
                Objects.equals(trainerName, client.trainerName) &&
                Objects.equals(bonus, client.bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, trainerId, trainerName, bonus);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", trainerId=" + trainerId +
                ", trainerName='" + trainerName + '\'' +
                ", bonus=" + bonus +
                '}';
    }
}
