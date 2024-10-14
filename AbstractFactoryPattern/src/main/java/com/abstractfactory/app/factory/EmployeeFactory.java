package com.abstractfactory.app.factory;

import com.abstractfactory.app.Employee;
import com.abstractfactory.app.factory.abst.EmployeeAbstractFactory;

public class EmployeeFactory {
    public static Employee getEmployee(EmployeeAbstractFactory factory){
        return factory.createEmployee();
    }
}
