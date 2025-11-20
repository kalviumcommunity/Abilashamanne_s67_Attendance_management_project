package com.school;

public class Student {
    private static int nextStudentIdCounter = 1;  // auto ID

    private int studentId;    // now encapsulated
    private String name;      // now encapsulated

    // Constructor
    public Student(String name) {
        this.studentId = nextStudentIdCounter++;
        this.name = name;
    }

    // Getters (no setters needed for now)
    public int getStudentId() {
        return this.studentId;
    }

    public String getName() {
        return this.name;
    }

    public void displayDetails() {
        System.out.println("Student ID   : " + studentId);
        System.out.println("Student Name : " + name);
        System.out.println("---------------------------------");
    }
}
