package com.nitish.recycler1;

/**
 * Created by nitish on 06-Nov-16.
 */

public class Employee {
    private String name,designation;

    public Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }
}
