package com.example.ipclawawareness;

public class Court {
    private String name;
    private String address;
    private String timings;
    private String phone;

    public Court() {
        // Required empty constructor for Firebase
    }

    public Court(String name, String address, String timings, String phone) {
        this.name = name;
        this.address = address;
        this.timings = timings;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTimings() {
        return timings;
    }

    public String getPhone() {
        return phone;
    }
}

