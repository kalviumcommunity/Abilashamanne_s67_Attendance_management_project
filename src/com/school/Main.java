package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the Attendance System!");
        System.out.println("----- Part 6: Interface-Driven Persistence & Storage -----\n");

        // ===== Students (using List) =====
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", "Grade 10"));
        students.add(new Student("Bob", "Grade 11"));
        students.add(new Student("Charlie", "Grade 12"));

        // ===== Teachers =====
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("Dr. Smith", "Mathematics"));
        teachers.add(new Teacher("Ms. Johnson", "Computer Science"));

        // ===== Staff =====
        List<Staff> staffMembers = new ArrayList<>();
        staffMembers.add(new Staff("Mr. Brown", "Admin"));
        staffMembers.add(new Staff("Mrs. Clark", "Librarian"));

        // ===== Courses (also List) =====
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Mathematics"));
        courses.add(new Course("Computer Science"));

        // ===== Display Person hierarchy =====
        System.out.println("----- Person Hierarchy Details -----\n");

        System.out.println("Students:");
        for (Student s : students) {
            s.displayDetails();
        }

        System.out.println("Teachers:");
        for (Teacher t : teachers) {
            t.displayDetails();
        }

        System.out.println("Staff Members:");
        for (Staff st : staffMembers) {
            st.displayDetails();
        }

        System.out.println("----- Course Details -----");
        for (Course c : courses) {
            c.displayDetails();
        }

        // ===== Attendance Records =====
        System.out.println("----- Attendance Records -----");
        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        // Use getId() from Person and getCourseId() from Course
        attendanceLog.add(new AttendanceRecord(
                students.get(0).getId(),
                courses.get(0).getCourseId(),
                "Present"
        ));
        attendanceLog.add(new AttendanceRecord(
                students.get(1).getId(),
                courses.get(0).getCourseId(),
                "Absent"
        ));
        attendanceLog.add(new AttendanceRecord(
                students.get(2).getId(),
                courses.get(1).getCourseId(),
                "present"   // valid, lowercase
        ));
        attendanceLog.add(new AttendanceRecord(
                students.get(0).getId(),
                courses.get(1).getCourseId(),
                "Late"      // invalid to trigger warning
        ));

        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

        // ===== Save to files using FileStorageService =====
        FileStorageService storageService = new FileStorageService();
        storageService.saveData(students, "students.txt");
        storageService.saveData(courses, "courses.txt");
        storageService.saveData(attendanceLog, "attendance_log.txt");

        System.out.println("\nCheck 'students.txt', 'courses.txt', and 'attendance_log.txt' in the project folder.");
    }
}
