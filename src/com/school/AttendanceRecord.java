package com.school;

public class AttendanceRecord {
    private int studentId;
    private int courseId;
    private String status;

    public AttendanceRecord(int studentId, int courseId, String status) {
        this.studentId = studentId;
        this.courseId = courseId;

        if (status != null &&
                (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent"))) {
            // normalize: "Present" or "Absent"
            this.status = status.substring(0, 1).toUpperCase() + status.substring(1).toLowerCase();
        } else {
            System.out.println("Warning: Invalid attendance status '" + status
                    + "'. Setting status to 'Invalid'.");
            this.status = "Invalid";
        }
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getStatus() {
        return status;
    }

    public void displayRecord() {
        System.out.println("Attendance Record -> Student ID: " + studentId
                + ", Course ID: C" + courseId
                + ", Status: " + status);
    }
}
