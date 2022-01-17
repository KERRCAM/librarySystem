package com.company.Objects;

public class User {

    private String userEmail;
    private String userPassword;
    private String userAuthority;

    @Override
    public String toString() {
        return "User{" +
                "userEmail='" + userEmail + ',' +
                ", userPassword='" + userPassword + ',' +
                ", userAuthority='" + userAuthority + ',' +
                '}';
    }

    public User(String userEmail, String userPassword, String userAuthority) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userAuthority = userAuthority;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserAuthority() {
        return userAuthority;
    }

    public void setUserAuthority(String userAuthority) {
        this.userAuthority = userAuthority;
    }
}
