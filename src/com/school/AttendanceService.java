package com.school;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AttendanceService {

    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;
    private RegistrationService registrationService;

    public AttendanceService(FileStorageService storageService, RegistrationService registrationService) {
        this.storageService = storageService;
        this.registrationService = registrationService;
        this.attendanceLog = new ArrayList<>();
    }

    // 1️⃣ Mark attendance using Student & Course directly
    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
    }

    // 2️⃣ Mark attendance using IDs, lookups via RegistrationService
    public void markAttendance(int studentId, int courseId, String status) {
        Student student = registrationService.findStudentById(studentId);
        Course course = registrationService.findCourseById(courseId);

        if (student == null) {
            System.out.println("Warning: No student found with ID " + studentId + ". Attendance not recorded.");
            return;
        }

        if (course == null) {
            System.out.println("Warning: No course found with ID " + courseId + ". Attendance not recorded.");
            return;
        }

        markAttendance(student, course, status);
    }

    // ---- Display methods ----

    public void displayAttendanceLog() {
        System.out.println("===== Full Attendance Log =====");
        if (attendanceLog.isEmpty()) {
            System.out.println("No attendance records found.");
        } else {
            for (AttendanceRecord record : attendanceLog) {
                record.displayRecord();
            }
        }
        System.out.println();
    }

    public void displayAttendanceLog(Student student) {
        System.out.println("===== Attendance Log for Student: " + student.getName()
                + " (ID: " + student.getId() + ") =====");

        List<AttendanceRecord> filtered = attendanceLog.stream()
                .filter(r -> r.getStudent().getId() == student.getId())
                .collect(Collectors.toList());

        if (filtered.isEmpty()) {
            System.out.println("No attendance records for this student.");
        } else {
            for (AttendanceRecord record : filtered) {
                record.displayRecord();
            }
        }
        System.out.println();
    }

    public void displayAttendanceLog(Course course) {
        System.out.println("===== Attendance Log for Course: " + course.getCourseName()
                + " (ID: C" + course.getCourseId() + ") =====");

        List<AttendanceRecord> filtered = attendanceLog.stream()
                .filter(r -> r.getCourse().getCourseId() == course.getCourseId())
                .collect(Collectors.toList());

        if (filtered.isEmpty()) {
            System.out.println("No attendance records for this course.");
        } else {
            for (AttendanceRecord record : filtered) {
                record.displayRecord();
            }
        }
        System.out.println();
    }

    // ---- Save attendance ----

    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }
}
