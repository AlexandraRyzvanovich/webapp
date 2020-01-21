package com.epam.webapp.entity;

import java.util.Objects;

public class Trainer implements Identifiable{
    public static final String TRAINER_TABLE_NAME = "trainer";
    public static final String TRAINER_ID_COLUMN_NAME = "trainer_id";
    public static final String USER_ID_COLUMN_NAME = "user_id";

    User user;
    Trainer trainer;

    public Trainer(User user, Trainer trainer) {
        this.user = user;
        this.trainer = trainer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer1 = (Trainer) o;
        return Objects.equals(user, trainer1.user) &&
                Objects.equals(trainer, trainer1.trainer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, trainer);
    }
}
