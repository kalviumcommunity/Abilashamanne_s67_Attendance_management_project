package com.school;

public class Course {
    private static int nextCourseIdCounter = 101;  // auto ID from 101

    private int courseId;        // int & private
    private String courseName;   // private

    // Constructor
    public Course(String courseName) {
        this.courseId = nextCourseIdCounter++;
        this.courseName = courseName;
    }

    // Getters
    public int getCourseId() {
        return this.courseId;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void displayDetails() {
        System.out.println("Course ID   : C" + courseId);
        System.out.println("Course Name : " + courseName);
        System.out.println("---------------------------------");
    }
}
