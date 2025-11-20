package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("===== School Directory =====\n");
        for (Person person : people) {
            person.displayDetails();   // runtime polymorphism
        }
    }

    public static void main(String[] args) {

        System.out.println("Welcome to the Attendance System!");
        System.out.println("----- Part 8: Overloaded Attendance Commands & Queries -----\n");

        // ===== Set up core data =====
        List<Student> students = new ArrayList<>();
        Student student1 = new Student("Alice", "Grade 10");
        Student student2 = new Student("Bob", "Grade 11");
        Student student3 = new Student("Charlie", "Grade 12");
        students.add(student1);
        students.add(student2);
        students.add(student3);

        List<Teacher> teachers = new ArrayList<>();
        Teacher teacher1 = new Teacher("Dr. Smith", "Mathematics");
        Teacher teacher2 = new Teacher("Ms. Johnson", "Computer Science");
        teachers.add(teacher1);
        teachers.add(teacher2);

        List<Staff> staffMembers = new ArrayList<>();
        Staff staff1 = new Staff("Mr. Brown", "Admin");
        Staff staff2 = new Staff("Mrs. Clark", "Librarian");
        staffMembers.add(staff1);
        staffMembers.add(staff2);

        List<Course> courses = new ArrayList<>();
        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Computer Science");
        courses.add(course1);
        courses.add(course2);

        // ===== School directory (polymorphism from Part 7) =====
        List<Person> schoolPeople = new ArrayList<>();
        schoolPeople.addAll(students);
        schoolPeople.addAll(teachers);
        schoolPeople.addAll(staffMembers);

        displaySchoolDirectory(schoolPeople);

        // ===== Setup storage + attendance service =====
        FileStorageService storageService = new FileStorageService();
        AttendanceService attendanceService = new AttendanceService(storageService);

        // ===== Mark attendance using overloaded methods =====
        System.out.println("===== Marking Attendance (Overloaded Methods) =====");

        // Using Student & Course directly
        attendanceService.markAttendance(student1, course1, "Present");
        attendanceService.markAttendance(student2, course1, "Absent");
        attendanceService.markAttendance(student3, course2, "present"); // valid lowercase

        // Using IDs + lookup lists (markAttendance with int IDs)
        attendanceService.markAttendance(student1.getId(), course2.getCourseId(),
                "Late", students, courses); // invalid status -> should warn

        System.out.println();

        // ===== Display attendance in different ways =====
        attendanceService.displayAttendanceLog();               // all records
        attendanceService.displayAttendanceLog(student1);       // only Alice
        attendanceService.displayAttendanceLog(course1);        // only Mathematics

        // ===== Save attendance to file =====
        attendanceService.saveAttendanceData();

        // Also save students & courses like before
        storageService.saveData(students, "students.txt");
        storageService.saveData(courses, "courses.txt");

        System.out.println("Check 'attendance_log.txt', 'students.txt', and 'courses.txt' for saved data.");
    }
}
