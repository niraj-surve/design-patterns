package com.abstractfactory.app.factory.abst;

import com.abstractfactory.app.Employee;
import com.abstractfactory.app.WebDeveloper;

public class WebDevFactory implements EmployeeAbstractFactory{
    @Override
    public Employee createEmployee() {
        return new WebDeveloper();
    }
}
