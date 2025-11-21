package com.school;

import java.util.ArrayList;
import java.util.List;

public class Course implements Storable {
    private static int nextCourseIdCounter = 101;  // auto ID from 101

    private int courseId;
    private String courseName;
    private int capacity;
    private List<Student> enrolledStudents;

    public Course(String courseName, int capacity) {
        this.courseId = nextCourseIdCounter++;
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public int getCourseId() {
        return this.courseId;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public int getNumberOfEnrolledStudents() {
        return enrolledStudents.size();
    }

    // Try to enroll a student
    public boolean addStudent(Student student) {
        // avoid duplicate enrollment
        if (enrolledStudents.contains(student)) {
            return false;
        }
        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(student);
            return true;
        }
        return false;
    }

    public void displayDetails() {
        System.out.println("Course ID   : C" + courseId);
        System.out.println("Course Name : " + courseName);
        System.out.println("Capacity    : " + capacity);
        System.out.println("Enrolled    : " + getNumberOfEnrolledStudents() + " / " + capacity);
        System.out.println("---------------------------------");
    }

    @Override
    public String toDataString() {
        // courseId,courseName,capacity
        return courseId + "," + courseName + "," + capacity;
    }
}
