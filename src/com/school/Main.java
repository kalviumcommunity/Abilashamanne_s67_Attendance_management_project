package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the Attendance System!");
        System.out.println("----- Part 4: Data Encapsulation & Attendance Recording Validation -----\n");

        // Create Students (auto IDs)
        Student[] students = new Student[3];
        students[0] = new Student("Alice");
        students[1] = new Student("Bob");
        students[2] = new Student("Charlie");

        // Create Courses (auto IDs)
        Course[] courses = new Course[2];
        courses[0] = new Course("Mathematics");
        courses[1] = new Course("Computer Science");

        // Display Students
        System.out.println("----- Student Details -----");
        for (Student student : students) {
            student.displayDetails();
        }

        // Display Courses
        System.out.println("----- Course Details -----");
        for (Course course : courses) {
            course.displayDetails();
        }

        // Attendance recording using ArrayList
        System.out.println("----- Attendance Records -----");

        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        // Valid records
        attendanceLog.add(new AttendanceRecord(
                students[0].getStudentId(),
                courses[0].getCourseId(),
                "Present"
        ));

        attendanceLog.add(new AttendanceRecord(
                students[1].getStudentId(),
                courses[0].getCourseId(),
                "Absent"
        ));

        attendanceLog.add(new AttendanceRecord(
                students[2].getStudentId(),
                courses[1].getCourseId(),
                "present"  // lowercase, should still be accepted
        ));

        // Invalid status to test validation
        attendanceLog.add(new AttendanceRecord(
                students[0].getStudentId(),
                courses[1].getCourseId(),
                "Late"   // invalid status
        ));

        // Display all attendance records
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }
}
