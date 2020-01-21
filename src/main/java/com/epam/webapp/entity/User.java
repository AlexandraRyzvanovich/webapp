package com.epam.webapp.entity;

public class User implements Identifiable{
    public static final String USER_TABLE_NAME = "user";
    public static final String USER_ID_COLUMN_NAME = "id";
    public static final String FIRST_NAME_COLUMN_NAME = "first_name";
    public static final String LAST_NAME_COLUMN_NAME = "last_name";
    public static final String EMAIL_COLUMN_NAME = "email";
    public static final String PASSWORD_COLUMN_NAME = "password";
    public static final String ROLE_COLUMN_NAME = "role";
    public static final String BONUS_COLUMN_NAME = "bonus";

    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
    private Bonus bonus;

    public User(String login, String password) {
        this.email = login;
        this.password = password;
    }

    public User(String name) {
        this.firstName = name;
    }

    public User(String name, Role role) {
        this.firstName = name;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setLogin(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public Bonus getBonus() {
        return bonus;
    }

    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }
}
