package com.abstractfactory.app;

public class WebDeveloper implements Employee{
    @Override
    public int getSalary() {
        return 40000;
    }

    @Override
    public String getRole() {
        return "Web Developer";
    }
}
