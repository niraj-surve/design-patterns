### Abstract Factory Design Pattern

1. Define an interface or abstract class for creating families of related (or dependent) objects but without specifying their concrete sub-classes.
2. Also known as Kit.
3. Isolates the client code from concrete (implementation) classes.
4. It eases the exchanging of object families.
5. It promotes consistency among objects.

#### Usage

1. When the system needs to be independent of how its object are created, composed, and represented.
2. When the family of related objects has to be used together, then this constraint needs to be enforced.
3. When you want to provide a library of objects that does not show implementations and only reveals interfaces.
4. When the system needs to be configured with one of a multiple family of objects.

#### Implementation

Employee.java
```java
public interface Employee {
    int getSalary();

    String getRole();
}
```

AndroidDeveloper.java
```java
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
```

WebDeveloper.java
```java
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
```

EmployeeFactory.java
```java
public class EmployeeFactory {
    public static Employee getEmployee(EmployeeAbstractFactory factory){
        return factory.createEmployee();
    }
}
```

EmployeeAbstractFactory.java
```java
public interface EmployeeAbstractFactory {
    Employee createEmployee();
}
```

AndroidDevFactory.java
```java
public class AndroidDevFactory implements EmployeeAbstractFactory{
    @Override
    public Employee createEmployee() {
        return new AndroidDeveloper();
    }
}
```

WebDevFactory.java
```java
public class WebDevFactory implements EmployeeAbstractFactory{
    @Override
    public Employee createEmployee() {
        return new WebDeveloper();
    }
}
```

Main.java
```java
public class Main {
    public static void main(String[] args) {
        Employee employee1 = EmployeeFactory.getEmployee(new AndroidDevFactory());
        System.out.println("Role: " + employee1.getRole() + "\nSalary: " + employee1.getSalary());

        Employee employee2 = EmployeeFactory.getEmployee(new WebDevFactory());
        System.out.println("Role: " + employee2.getRole() + "\nSalary: " + employee2.getSalary());
    }
}
```