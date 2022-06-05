package com.psut.psutiam.db.entity;

public enum Role {

    Admin("ADMIN"), Instructor("Instructor"), Student("Student");

    String role;

    Role(String role) {
        this.role = role;
    }

    public String getLevel() {
        return role;
    }
}
