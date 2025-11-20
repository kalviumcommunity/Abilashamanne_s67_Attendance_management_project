package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the Attendance System!");
        System.out.println("----- Part 5: Person Hierarchy & Staff Roles -----\n");

        // ===== Create Students (inherit from Person) =====
        Student student1 = new Student("Alice", "Grade 10");
        Student student2 = new Student("Bob", "Grade 11");
        Student student3 = new Student("Charlie", "Grade 12");

        Student[] students = { student1, student2, student3 };

        // ===== Create Teacher(s) =====
        Teacher teacher1 = new Teacher("Dr. Smith", "Mathematics");
        Teacher teacher2 = new Teacher("Ms. Johnson", "Computer Science");

        // ===== Create Staff =====
        Staff staff1 = new Staff("Mr. Brown", "Admin");
        Staff staff2 = new Staff("Mrs. Clark", "Librarian");

        // ===== Display all Person hierarchy details =====
        System.out.println("----- Person Hierarchy Details -----\n");

        System.out.println("Students:");
        for (Student s : students) {
            s.displayDetails();
        }

        System.out.println("Teachers:");
        teacher1.displayDetails();
        teacher2.displayDetails();

        System.out.println("Staff Members:");
        staff1.displayDetails();
        staff2.displayDetails();

        // ===== Courses (same as before) =====
        Course[] courses = new Course[2];
        courses[0] = new Course("Mathematics");
        courses[1] = new Course("Computer Science");

        System.out.println("----- Course Details -----");
        for (Course course : courses) {
            course.displayDetails();
        }

        // ===== Attendance using AttendanceRecord + getId() =====
        System.out.println("----- Attendance Records -----");

        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        // Use student.getId() and course.getCourseId()
        attendanceLog.add(new AttendanceRecord(
                student1.getId(),
                courses[0].getCourseId(),
                "Present"
        ));

        attendanceLog.add(new AttendanceRecord(
                student2.getId(),
                courses[0].getCourseId(),
                "Absent"
        ));

        attendanceLog.add(new AttendanceRecord(
                student3.getId(),
                courses[1].getCourseId(),
                "present"   // should be accepted as valid
        ));

        // Invalid status to test validation
        attendanceLog.add(new AttendanceRecord(
                student1.getId(),
                courses[1].getCourseId(),
                "Late"      // invalid, should show warning + 'Invalid'
        ));

        // Display all records
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }
}
