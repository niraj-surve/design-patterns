### Factory Design Pattern

1. Define an interface or abstract class for creating an object but let the subclasses decide which class to instantiate.
2. Allows the sub-classes to choose the type of objects to create.
3. Promotes Loose Coupling

#### Usage
1. When a class doesn't know what sub-classes will be required to create.
2. When a class wants that its sub-classes specify the objects to be created.
3. When the parent classes choose the creation of objects to its sub-classes.

#### Implementation

Employee Interface

```java
public interface Employee {
    int salary();
}
```

AndroidDeveloper.java
```java
public class AndroidDeveloper implements  Employee{
    @Override
    public int salary() {
        return 50000;
    }
}
```

WebDeveloper.java
```java
public class WebDeveloper implements Employee{
    @Override
    public int salary() {
        return 40000;
    }
}
```

EmployeeFactory.java
```java
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
```

Main.java
```java
public class Main {
    public static void main(String[] args) {
        Employee employee1 = EmployeeFactory.getEmployee("ANDROID DEVELOPER");
        System.out.println("Salary of Android Developer: $" + employee1.salary());

        Employee employee2 = EmployeeFactory.getEmployee("WEB DEVELOPER");
        System.out.println("Salary of Web Developer: $" + employee2.salary());
    }
}
```