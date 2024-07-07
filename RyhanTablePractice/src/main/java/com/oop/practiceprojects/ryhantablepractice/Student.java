package com.oop.practiceprojects.ryhantablepractice;

public class Student {
    String name, course;
    int ID, section;

    public Student(String name, String course, int ID, int section) {
        this.name = name;
        this.course = course;
        this.ID = ID;
        this.section = section;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSec() {
        return section;
    }

    public void setSec(int sec) {
        this.section = sec;
    }
}
