package com.abstractfactory.app;

public class AndroidDeveloper implements Employee{
    @Override
    public int getSalary() {
        return 50000;
    }

    @Override
    public String getRole() {
        return "Android Developer";
    }
}
