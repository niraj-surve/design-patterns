package com.factory.app;

public class EmployeeFactory {
    public static Employee getEmployee(String employeeType){
        if(employeeType.trim().equals("ANDROID DEVELOPER")){
            return new AndroidDeveloper();
        } else if (employeeType.trim().equals("WEB DEVELOPER")){
            return new WebDeveloper();
        } else {
            return null;
        }
    }
}
