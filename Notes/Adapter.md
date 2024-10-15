### Adapter Design Pattern

1. Converts the interface of a class into another interface that a client wants.
2. In other words, to provide the interface according to client requirement while using the services of a class with a different interface.
3. Also known as Wrapper.
4. It allows two or more previously incompatible objects to interact.
5. It allows reusability of existing functionality.

#### Usage

1. When an object needs to utilize an existing class with an incompatible interface.
2. When you want to create a reusable class that cooperates with classes which don't have compatible interfaces.
3. When you want to create a reusable class that cooperates with classes which don't have compatible interfaces.

#### Implementation

Iphone16.java
```java
public class Iphone16 {

    private AppleCharger appleCharger;

    public Iphone16(AppleCharger appleCharger) {
        this.appleCharger = appleCharger;
    }

    public void charge(){
        appleCharger.chargeIphone();
    }
}
```

AppleCharger.java
```java
public interface AppleCharger {
    void chargeIphone();
}
```

LightCharger.java
```java
public class LightCharger implements AppleCharger{
    @Override
    public void chargeIphone() {
        System.out.println("Charging Iphone with lightning cable!");
    }
}
```

AndroidCharger.java
```java
public interface AndroidCharger {
    void chargeAndoid();
}
```

TypeCCharger.java
```java
public class TypeCCharger implements AndroidCharger{
    @Override
    public void chargeAndoid() {
        System.out.println("Charging android with type c cable!");
    }
}
```

Light2CAdapater.java
```java
public class Light2CAdapter implements AppleCharger {

    private AndroidCharger androidCharger;

    public Light2CAdapter(AndroidCharger androidCharger) {
        this.androidCharger = androidCharger;
    }

    @Override
    public void chargeIphone() {
        androidCharger.chargeAndoid();
        System.out.println("Your iphone is charging via light to type c adapter.");
    }
}
```

Main.java
```java
public class Main {
    public static void main(String[] args) {

        AndroidCharger androidCharger = new TypeCCharger();

        AppleCharger appleCharger = new Light2CAdapter(androidCharger);

        Iphone16 iphone = new Iphone16(appleCharger);

        iphone.charge();

    }
}
```