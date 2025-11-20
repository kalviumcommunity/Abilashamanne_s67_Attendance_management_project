package com.school;

public class Course {
    private static int nextCourseIdCounter = 101;  // auto ID starting from 101

    private int courseId;       // changed to int
    private String courseName;

    // Constructor to initialize course with auto-generated ID
    public Course(String courseName) {
        this.courseId = nextCourseIdCounter++;
        this.courseName = courseName;
    }

    public void displayDetails() {
        System.out.println("Course ID   : C" + courseId);   // e.g., C101, C102
        System.out.println("Course Name : " + courseName);
        System.out.println("---------------------------------");
    }
}
