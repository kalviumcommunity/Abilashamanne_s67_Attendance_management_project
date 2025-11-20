package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("===== School Directory =====\n");
        for (Person person : people) {
            person.displayDetails();   // runtime polymorphism in action
        }
    }

    public static void main(String[] args) {

        System.out.println("Welcome to the Attendance System!");
        System.out.println("----- Part 7: Polymorphic Behaviour & Reports -----\n");

        // ===== Students =====
        List<Student> students = new ArrayList<>();
        Student student1 = new Student("Alice", "Grade 10");
        Student student2 = new Student("Bob", "Grade 11");
        Student student3 = new Student("Charlie", "Grade 12");
        students.add(student1);
        students.add(student2);
        students.add(student3);

        // ===== Teachers =====
        List<Teacher> teachers = new ArrayList<>();
        Teacher teacher1 = new Teacher("Dr. Smith", "Mathematics");
        Teacher teacher2 = new Teacher("Ms. Johnson", "Computer Science");
        teachers.add(teacher1);
        teachers.add(teacher2);

        // ===== Staff =====
        List<Staff> staffMembers = new ArrayList<>();
        Staff staff1 = new Staff("Mr. Brown", "Admin");
        Staff staff2 = new Staff("Mrs. Clark", "Librarian");
        staffMembers.add(staff1);
        staffMembers.add(staff2);

        // ===== Courses =====
        List<Course> courses = new ArrayList<>();
        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Computer Science");
        courses.add(course1);
        courses.add(course2);

        // ===== Polymorphic School Directory =====
        List<Person> schoolPeople = new ArrayList<>();
        schoolPeople.addAll(students);
        schoolPeople.addAll(teachers);
        schoolPeople.addAll(staffMembers);

        displaySchoolDirectory(schoolPeople);

        // ===== Attendance Records (now using Student & Course objects) =====
        System.out.println("===== Attendance Log =====");

        List<AttendanceRecord> attendanceLog = new ArrayList<>();
        attendanceLog.add(new AttendanceRecord(student1, course1, "Present"));
        attendanceLog.add(new AttendanceRecord(student2, course1, "Absent"));
        attendanceLog.add(new AttendanceRecord(student3, course2, "present")); // valid
        attendanceLog.add(new AttendanceRecord(student1, course2, "Late"));    // invalid, triggers warning

        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

        // ===== Saving Data to Files via Storable & FileStorageService =====
        FileStorageService storageService = new FileStorageService();

        // Filter students from schoolPeople using instanceof (Person is NOT Storable)
        List<Student> studentsForSaving = new ArrayList<>();
        for (Person person : schoolPeople) {
            if (person instanceof Student) {
                studentsForSaving.add((Student) person);
            }
        }

        storageService.saveData(studentsForSaving, "students.txt");
        storageService.saveData(courses, "courses.txt");
        storageService.saveData(attendanceLog, "attendance_log.txt");

        System.out.println("\nCheck 'students.txt', 'courses.txt', and 'attendance_log.txt' for saved data.");
    }
}
