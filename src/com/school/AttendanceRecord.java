package com.school;

public class AttendanceRecord implements Storable {
    private Student student;
    private Course course;
    private String status;

    public AttendanceRecord(Student student, Course course, String status) {
        this.student = student;
        this.course = course;

        if (status != null &&
                (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent"))) {
            this.status = status.substring(0, 1).toUpperCase() + status.substring(1).toLowerCase();
        } else {
            System.out.println("Warning: Invalid attendance status '" + status
                    + "'. Setting status to 'Invalid'.");
            this.status = "Invalid";
        }
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getStatus() {
        return status;
    }

    public void displayRecord() {
        System.out.println(
                "Attendance Record -> " +
                "Student: " + student.getName() + " (ID: " + student.getId() + "), " +
                "Course: " + course.getCourseName() + " (ID: C" + course.getCourseId() + "), " +
                "Status: " + status
        );
    }

    @Override
    public String toDataString() {
        // Still use IDs for storage: studentId,courseId,status
        return student.getId() + "," + course.getCourseId() + "," + status;
    }
}
