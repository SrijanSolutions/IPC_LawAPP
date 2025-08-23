package com.example.ipclawawareness;

public class Lawyer {
    private String name;
    private String specialization;
    private String experience;
    private String phone;
    private String email;

    public Lawyer() {
        // Required empty constructor for Firebase
    }

    public Lawyer(String name, String specialization, String experience, String phone, String email) {
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getExperience() {
        return experience;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}