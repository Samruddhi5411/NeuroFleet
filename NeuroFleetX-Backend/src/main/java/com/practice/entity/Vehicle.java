package com.practice.entity;

import jakarta.persistence.*;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String status;   // Available/In Use/Needs Service
    private double battery;  // %
    private double fuel;     // %
    private String location; // Dummy GPS coordinates "lat,long"

    // Constructors
    public Vehicle() {}

    public Vehicle(Long id, String name, String status, double battery, double fuel, String location) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.battery = battery;
        this.fuel = fuel;
        this.location = location;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double getBattery() { return battery; }
    public void setBattery(double battery) { this.battery = battery; }

    public double getFuel() { return fuel; }
    public void setFuel(double fuel) { this.fuel = fuel; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
