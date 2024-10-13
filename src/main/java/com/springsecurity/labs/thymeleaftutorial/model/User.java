package com.springsecurity.labs.thymeleaftutorial.model;

public class User {
    public String name;
    public String email;
    public String role;
    public String gender;

    public User(String gender, String role, String email, String name) {
        this.gender = gender;
        this.role = role;
        this.email = email;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



}