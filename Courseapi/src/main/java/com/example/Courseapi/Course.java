package com.example.Courseapi;

public class Course {
    private int id;
    private String name;
    private String description;
    private String instructor;

    public Course(int id, String name, String description, String instructor) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.instructor = instructor;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getInstructor() {
        return instructor;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}
