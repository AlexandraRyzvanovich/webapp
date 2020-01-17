package com.epam.webapp.entity;

public class User implements Identifiable{
    public static final String NAME = "first_name";
    public static final String TABLE_NAME = "user";
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Bonus bonus;

    private Role role;

    public User(String login, String password) {
        this.email = login;
        this.password = password;
    }

    public User(String name) {
        this.firstName = name;
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
