package com.school;

public class Student {
    private static int nextStudentIdCounter = 1;  // auto ID generator

    private int studentId;
    private String name;

    // Constructor to initialize student with auto ID
    public Student(String name) {
        this.studentId = nextStudentIdCounter++;
        this.name = name;  // 'this' used to refer to instance variable
    }

    public void displayDetails() {
        System.out.println("Student ID   : " + studentId);
        System.out.println("Student Name : " + name);
        System.out.println("---------------------------------");
    }
}
