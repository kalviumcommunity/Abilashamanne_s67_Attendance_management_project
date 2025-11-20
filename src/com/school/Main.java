package com.school;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the Attendance System!");
        System.out.println("----- Part 2: Core Domain Modelling -----\n");

        // Students array
        Student[] students = new Student[3];

        students[0] = new Student();
        students[0].setDetails(1, "Alice");

        students[1] = new Student();
        students[1].setDetails(2, "Bob");

        students[2] = new Student();
        students[2].setDetails(3, "Charlie");

        // Courses array
        Course[] courses = new Course[2];

        courses[0] = new Course();
        courses[0].setDetails(101, "Mathematics");

        courses[1] = new Course();
        courses[1].setDetails(102, "Computer Science");

        // Show students
        System.out.println("----- Student Details -----");
        for (int i = 0; i < students.length; i++) {
            students[i].displayDetails();
        }

        // Show courses
        System.out.println("----- Course Details -----");
        for (int i = 0; i < courses.length; i++) {
            courses[i].displayDetails();
        }
    }
}
