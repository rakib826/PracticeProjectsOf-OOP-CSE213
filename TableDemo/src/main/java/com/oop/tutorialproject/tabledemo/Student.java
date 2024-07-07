package com.oop.tutorialproject.tabledemo;

public class Student {
    private String name;
    private int id;
    private float cgpa;
    private String semester;

    public Student(String name, int id,  float cgpa, String semester) {
        this.name = name;
        this.id = id;
        this.cgpa = cgpa;
        this.semester = semester;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", cgpa='" + cgpa + '\'' +
                ", semester='" + semester + '\'' +
                '}';
    }
}
