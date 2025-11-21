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

    // Optional helper: mark attendance only if enrolled
    private static void safeMarkAttendance(AttendanceService attendanceService,
                                           Student student, Course course, String status) {
        if (course.getEnrolledStudents().contains(student)) {
            attendanceService.markAttendance(student.getId(), course.getCourseId(), status);
        } else {
            System.out.println("Cannot mark attendance for " + student.getName()
                    + " in " + course.getCourseName() + " - student not enrolled.");
        }
    }

    public static void main(String[] args) {

        System.out.println("Welcome to the Attendance System!");
        System.out.println("----- Part 10: Capacity Management & Project Wrap-up -----\n");

        // ---- Instantiate services ----
        FileStorageService storageService = new FileStorageService();
        RegistrationService registrationService = new RegistrationService(storageService);
        AttendanceService attendanceService = new AttendanceService(storageService, registrationService);

        // ---- Register students, teachers, staff ----
        Student student1 = registrationService.registerStudent("Alice", "Grade 10");
        Student student2 = registrationService.registerStudent("Bob", "Grade 11");
        Student student3 = registrationService.registerStudent("Charlie", "Grade 12");

        Teacher teacher1 = registrationService.registerTeacher("Dr. Smith", "Mathematics");
        Teacher teacher2 = registrationService.registerTeacher("Ms. Johnson", "Computer Science");

        Staff staff1 = registrationService.registerStaff("Mr. Brown", "Admin");
        Staff staff2 = registrationService.registerStaff("Mrs. Clark", "Librarian");

        // ---- Create courses with capacities ----
        Course course1 = registrationService.createCourse("Mathematics", 2);      // capacity 2
        Course course2 = registrationService.createCourse("Computer Science", 1); // capacity 1

        // ---- Show school directory ----
        displaySchoolDirectory(registrationService);

        // ---- Enroll students with a capacity overflow attempt ----
        System.out.println("===== Enrollment Attempts =====");
        registrationService.enrollStudentInCourse(student1, course1); // ok
        registrationService.enrollStudentInCourse(student2, course1); // ok
        registrationService.enrollStudentInCourse(student3, course1); // should fail (over capacity)

        registrationService.enrollStudentInCourse(student1, course2); // ok
        registrationService.enrollStudentInCourse(student2, course2); // should fail (over capacity)

        System.out.println();

        // ---- Show course details with capacity & enrollment count ----
        System.out.println("===== Course Details (Capacity & Enrollment) =====");
        for (Course c : registrationService.getCourses()) {
            c.displayDetails();
        }

        System.out.println();

        // ---- Mark attendance (only if enrolled) ----
        System.out.println("===== Attendance Marking (with enrollment check) =====");
        safeMarkAttendance(attendanceService, student1, course1, "Present");
        safeMarkAttendance(attendanceService, student2, course1, "Absent");
        safeMarkAttendance(attendanceService, student3, course1, "Present"); // not enrolled -> should show warning

        safeMarkAttendance(attendanceService, student1, course2, "present"); // valid
        safeMarkAttendance(attendanceService, student2, course2, "Late");    // not enrolled + invalid status

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
        System.out.println("- courses.txt (with capacity)");
        System.out.println("- attendance_log.txt");
    }
}
