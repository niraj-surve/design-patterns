package com.abstractfactory.app;

import com.abstractfactory.app.factory.EmployeeFactory;
import com.abstractfactory.app.factory.abst.AndroidDevFactory;
import com.abstractfactory.app.factory.abst.WebDevFactory;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = EmployeeFactory.getEmployee(new AndroidDevFactory());
        System.out.println("Role: " + employee1.getRole() + "\nSalary: " + employee1.getSalary());

        Employee employee2 = EmployeeFactory.getEmployee(new WebDevFactory());
        System.out.println("Role: " + employee2.getRole() + "\nSalary: " + employee2.getSalary());
    }
}
