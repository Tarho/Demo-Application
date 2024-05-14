package com.example.patientapplication.model;

public class Account {
    private String PhoneNumber;
    private String Password;
    private boolean Role;

    public Account(String PhoneNumber, String Password, boolean Role) {
        this.PhoneNumber = PhoneNumber;
        this.Password = Password;
        this.Role = Role;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public boolean isRole() {
        return Role;
    }

    public void setRole(boolean role) {
        Role = role;
    }
}
