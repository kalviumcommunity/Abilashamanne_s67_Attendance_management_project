package com.school;

public class Course implements Storable {
    private static int nextCourseIdCounter = 101;  // auto ID from 101

    private int courseId;
    private String courseName;

    public Course(String courseName) {
        this.courseId = nextCourseIdCounter++;
        this.courseName = courseName;
    }

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

    @Override
    public String toDataString() {
        // courseId,courseName
        return courseId + "," + courseName;
    }
}
