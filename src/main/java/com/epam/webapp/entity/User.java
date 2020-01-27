package com.epam.webapp.entity;

import java.util.Objects;

public class User implements Identifiable{
    public static final String USER_TABLE_NAME = "user";
    public static final String USER_ID_COLUMN_NAME = "id";
    public static final String FIRST_NAME_COLUMN_NAME = "first_name";
    public static final String LAST_NAME_COLUMN_NAME = "last_name";
    public static final String EMAIL_COLUMN_NAME = "email";
    public static final String PASSWORD_COLUMN_NAME = "password";
    public static final String BONUS_COLUMN_NAME = "bonus";
    public static final String TRAINER_ID_COLUMN_NAME = "trainer_id";
    public static final String ROLE_COLUMN_NAME = "role";

    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer bonus;
    private Long trainerId;
    private Role role;

    public User(Long userId, String firstName, String lastName, String email, String password, Integer bonus, Long trainerId, Role role) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.bonus = bonus;
        this.trainerId = trainerId;
        this.role = role;
    }

    public User(Long id, String name, String lastName, String email, Role role, int bonus) {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(bonus, user.bonus) &&
                Objects.equals(trainerId, user.trainerId) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, email, password, bonus, trainerId, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", bonus=" + bonus +
                ", trainerId=" + trainerId +
                ", role=" + role +
                '}';
    }
}
