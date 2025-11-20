package com.school;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AttendanceService {

    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;

    public AttendanceService(FileStorageService storageService) {
        this.storageService = storageService;
        this.attendanceLog = new ArrayList<>();
    }

    // 1️ Mark attendance using Student & Course objects directly
    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
    }

    // 2️ Mark attendance using IDs + lookup in lists
    public void markAttendance(int studentId, int courseId, String status,
                               List<Student> allStudents, List<Course> allCourses) {
        Student student = findStudentById(studentId, allStudents);
        Course course = findCourseById(courseId, allCourses);

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

    //  Helper lookups
    private Student findStudentById(int id, List<Student> allStudents) {
        for (Student s : allStudents) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    private Course findCourseById(int id, List<Course> allCourses) {
        for (Course c : allCourses) {
            if (c.getCourseId() == id) {
                return c;
            }
        }
        return null;
    }

    //  Display all attendance
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

    // Filtered by student (using Streams)
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

    // Filtered by course (using Streams)
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

    //  Save attendance to file
    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }
}
