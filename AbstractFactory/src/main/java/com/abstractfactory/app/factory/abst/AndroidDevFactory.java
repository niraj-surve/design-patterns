package com.abstractfactory.app.factory.abst;

import com.abstractfactory.app.AndroidDeveloper;
import com.abstractfactory.app.Employee;

public class AndroidDevFactory implements EmployeeAbstractFactory{
    @Override
    public Employee createEmployee() {
        return new AndroidDeveloper();
    }
}
