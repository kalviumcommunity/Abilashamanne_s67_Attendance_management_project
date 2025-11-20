package com.school;

public class Course {
    private int courseId;
    private String courseName;

    public void setDetails(int courseId, String courseName) {
        this.courseId = courseId;  // using 'this'
        this.courseName = courseName;
    }

    public void displayDetails() {
        System.out.println("Course ID   : " + courseId);
        System.out.println("Course Name : " + courseName);
        System.out.println("---------------------------------");
    }
}
