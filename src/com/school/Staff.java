package com.school;

public class Staff extends Person implements Storable {

    private String role;

    public Staff(String name, String role) {
        super(name);
        this.role = role;
    }

    public String getStaffRole() {
        return role;
    }

    @Override
    public void displayDetails() {
        System.out.println("Role : Staff");
        super.displayDetails();
        System.out.println("Staff Role : " + role);
        System.out.println("---------------------------------");
    }

    @Override
    public String toDataString() {
        // id,name,role
        return getId() + "," + getName() + "," + role;
    }
}
