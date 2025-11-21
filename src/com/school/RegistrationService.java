package com.school;

import java.util.ArrayList;
import java.util.List;

public class RegistrationService {

    private final List<Student> students;
    private final List<Teacher> teachers;
    private final List<Staff> staffMembers;
    private final List<Course> courses;

    private final FileStorageService storageService;

    public RegistrationService(FileStorageService storageService) {
        this.storageService = storageService;
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.staffMembers = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    // ---- Registration methods ----

    public Student registerStudent(String name, String gradeLevel) {
        Student student = new Student(name, gradeLevel);
        students.add(student);
        return student;
    }

    public Teacher registerTeacher(String name, String subjectTaught) {
        Teacher teacher = new Teacher(name, subjectTaught);
        teachers.add(teacher);
        return teacher;
    }

    public Staff registerStaff(String name, String role) {
        Staff staff = new Staff(name, role);
        staffMembers.add(staff);
        return staff;
    }

    public Course createCourse(String courseName) {
        Course course = new Course(courseName);
        courses.add(course);
        return course;
    }

    // ---- Getters for lists ----

    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Staff> getStaffMembers() {
        return staffMembers;
    }

    public List<Course> getCourses() {
        return courses;
    }

    // ---- Lookup methods ----

    public Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public Course findCourseById(int id) {
        for (Course c : courses) {
            if (c.getCourseId() == id) {
                return c;
            }
        }
        return null;
    }

    // ---- All people (for school directory) ----

    public List<Person> getAllPeople() {
        List<Person> people = new ArrayList<>();
        people.addAll(students);
        people.addAll(teachers);
        people.addAll(staffMembers);
        return people;
    }

    // ---- Save all registrations ----

    public void saveAllRegistrations() {
        storageService.saveData(students, "students.txt");
        storageService.saveData(teachers, "teachers.txt");
        storageService.saveData(staffMembers, "staff.txt");
        storageService.saveData(courses, "courses.txt");
    }
}
