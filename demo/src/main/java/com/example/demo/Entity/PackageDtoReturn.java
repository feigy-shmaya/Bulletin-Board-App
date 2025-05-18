package com.example.demo.Entity;

public class PackageDtoReturn {

    private int entrances;
    private int days;
    private int id;
    // Constructor
    public PackageDtoReturn(int entrances, int days,int id) {
        this.entrances = entrances;
        this.days = days;
        this.id=id;
    }

    // Getters and Setters
    public int getEntrances() {
        return entrances;
    }
    public int getId() {
        return id;
    }
    public void setEntrances(int entrances) {
        this.entrances = entrances;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
