package com.factory.app;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = EmployeeFactory.getEmployee("ANDROID DEVELOPER");
        System.out.println("Salary of Android Developer: $" + employee1.salary());

        Employee employee2 = EmployeeFactory.getEmployee("WEB DEVELOPER");
        System.out.println("Salary of Web Developer: $" + employee2.salary());
    }
}
