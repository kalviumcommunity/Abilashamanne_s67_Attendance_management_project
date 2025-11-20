package com.school;

public class Student extends Person {

    private String gradeLevel;

    public Student(String name, String gradeLevel) {
        super(name);               // Person handles id + name
        this.gradeLevel = gradeLevel;
    }

    public String getGradeLevel() {
        return this.gradeLevel;
    }

    @Override
    public void displayDetails() {
        System.out.println("Role : Student");
        super.displayDetails();
        System.out.println("Grade Level : " + gradeLevel);
        System.out.println("---------------------------------");
    }
}
