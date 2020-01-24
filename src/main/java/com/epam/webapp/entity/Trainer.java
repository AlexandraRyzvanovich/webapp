package com.epam.webapp.entity;

import java.util.Objects;

public class Trainer implements Identifiable{
    public static final String TRAINER_TABLE_NAME = "trainer";
    public static final String TRAINER_ID_COLUMN_NAME = "trainer_id";
    public static final String USER_ID_COLUMN_NAME = "user_id";

    Long trainerId;
    User user;

    public Trainer(User user, Long trainer) {
        this.user = user;
        this.trainerId = trainer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getTrainer() {
        return trainerId;
    }

    public void setTrainer(Long trainer) {
        this.trainerId = trainer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer1 = (Trainer) o;
        return Objects.equals(user, trainer1.user) &&
                Objects.equals(trainerId, trainer1.trainerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, trainerId);
    }
}
