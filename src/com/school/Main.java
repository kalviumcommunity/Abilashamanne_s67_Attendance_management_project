package com.school;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the Attendance System!");
        System.out.println("----- Part 3: Constructor Initialization & Auto-ID Generation -----\n");

        // Create Students using constructor (auto IDs)
        Student[] students = new Student[4];
        students[0] = new Student("Alice");
        students[1] = new Student("Bob");
        students[2] = new Student("Charlie");
        students[3] = new Student("David");  // extra student to show ID increments

        // Create Courses using constructor (auto IDs)
        Course[] courses = new Course[3];
        courses[0] = new Course("Mathematics");
        courses[1] = new Course("Computer Science");
        courses[2] = new Course("Physics");  // extra course to show ID increments

        // Display Students
        System.out.println("----- Student Details -----");
        for (int i = 0; i < students.length; i++) {
            students[i].displayDetails();
        }

        // Display Courses
        System.out.println("----- Course Details -----");
        for (int i = 0; i < courses.length; i++) {
            courses[i].displayDetails();
        }
    }
}
