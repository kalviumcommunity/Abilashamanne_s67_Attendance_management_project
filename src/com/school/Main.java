package com.school;

import java.util.List;

public class Main {

    public static void displaySchoolDirectory(RegistrationService registrationService) {
        System.out.println("===== School Directory =====\n");
        List<Person> people = registrationService.getAllPeople();
        for (Person person : people) {
            person.displayDetails();   // runtime polymorphism
        }
    }

    public static void main(String[] args) {

        System.out.println("Welcome to the Attendance System!");
        System.out.println("----- Part 9: SOLID Service Layer (Registration & Attendance Separation) -----\n");

        // ---- Instantiate services ----
        FileStorageService storageService = new FileStorageService();
        RegistrationService registrationService = new RegistrationService(storageService);
        AttendanceService attendanceService = new AttendanceService(storageService, registrationService);

        // ---- Register students, teachers, staff, courses via RegistrationService ----
        Student student1 = registrationService.registerStudent("Alice", "Grade 10");
        Student student2 = registrationService.registerStudent("Bob", "Grade 11");
        Student student3 = registrationService.registerStudent("Charlie", "Grade 12");

        Teacher teacher1 = registrationService.registerTeacher("Dr. Smith", "Mathematics");
        Teacher teacher2 = registrationService.registerTeacher("Ms. Johnson", "Computer Science");

        Staff staff1 = registrationService.registerStaff("Mr. Brown", "Admin");
        Staff staff2 = registrationService.registerStaff("Mrs. Clark", "Librarian");

        Course course1 = registrationService.createCourse("Mathematics");
        Course course2 = registrationService.createCourse("Computer Science");

        // ---- Display school directory using RegistrationService ----
        displaySchoolDirectory(registrationService);

        // ---- Mark attendance using ID-based overloaded method ----
        System.out.println("===== Marking Attendance (ID-based calls) =====");
        attendanceService.markAttendance(student1.getId(), course1.getCourseId(), "Present");
        attendanceService.markAttendance(student2.getId(), course1.getCourseId(), "Absent");
        attendanceService.markAttendance(student3.getId(), course2.getCourseId(), "present");
        attendanceService.markAttendance(student1.getId(), course2.getCourseId(), "Late"); // invalid -> warning

        System.out.println();

        // ---- Display attendance reports ----
        attendanceService.displayAttendanceLog();         // all records
        attendanceService.displayAttendanceLog(student1); // filtered by student
        attendanceService.displayAttendanceLog(course1);  // filtered by course

        // ---- Save all data ----
        registrationService.saveAllRegistrations();
        attendanceService.saveAttendanceData();

        System.out.println("Data saved. Check:");
        System.out.println("- students.txt");
        System.out.println("- teachers.txt");
        System.out.println("- staff.txt");
        System.out.println("- courses.txt");
        System.out.println("- attendance_log.txt");
    }
}
