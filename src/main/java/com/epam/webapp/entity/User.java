package com.epam.webapp.entity;

public class User implements Identifiable{
    private Long userId;
    private String login;
    private String password;
    private Role role;
    public static String NAME;
    public static final String TABLE_NAME = "User";

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String NAME) {
        this.NAME = NAME;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
}
