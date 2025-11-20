package com.school;

public class Student {
    private int studentId;
    private String name;

    public void setDetails(int studentId, String name) {
        this.studentId = studentId;  // using 'this'
        this.name = name;
    }

    public void displayDetails() {
        System.out.println("Student ID   : " + studentId);
        System.out.println("Student Name : " + name);
        System.out.println("---------------------------------");
    }
}
