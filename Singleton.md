### Singleton Design Pattern
  - An object should have only one instance across the application.
  - Used in Logging, Cache, Session and Drivers.

#### Implementation
  - Private constructor:
  	```java
	private Logger(){}
	```
  - Static field to hold the single instance.
	```java
	private static Logger instance;
	```
  - public method (typically getInstance()) that returns the singleton instance.
  	```java
	public static Logger getInstance(){
  		// Object initialization code
  	}
	```

#### Initialization Types
1. Lazy Initialization
  	- Object is created when the getInstance method of type public is called.
  	- Not a thread-safe.
  	- Example -
	```java
	private static Logger instance;

  	public static Logger getInstance(){
		if(instance == null){
			instance = new Logger();
		}
		return instance;
    }
	```
    		
2. Eager Initialization
  	- Object is created when the class is loaded.
  	- Not a thread-safe.
  	```java
	private static Logger instance = new Logger();
  		
  	public static Logger getInstance(){
  		return instance;
  	}
	```
  	
3) Thread-safe Method Initialization
  	- Making the getInstance method as synchronized.
  	```java
	private static Logger instance;

  	public static synchronized Logger getInstance(){
		if(instance == null){
			instance = new Logger();
		}
		return instance;
    }
	```
  	
4) Thread-safe Block Initialization
  	- Synchronizing only the block where actual object is created.
  	```java
	public static Logger getInstance(){
  		synchronized (Logger.class){
        	if(instance == null){
            	instance = new Logger();
        	}
        }
    	return instance;
  	}
	```


### Ways to break singleton pattern
#### 1. Reflection API
```java
Logger logger1 = Logger.getInstance();

logger1.log(LogLevel.INFO,  "" + logger1.hashCode());

Constructor<Logger> constructor = Logger.class.getDeclaredConstructor();
constructor.setAccessible(true);
Logger logger2 = constructor.newInstance();

logger2.log(LogLevel.INFO, "" + logger2.hashCode());
```

**Output**
```
[10-10-2024 15:11:19] INFO: 1175962212
[10-10-2024 15:11:19] INFO: 258952499
```

**Solution**
1. If object is already there then throw runtime exception in constructor.
```java
private Logger(){
	if(instance != null){
		throw new RuntimeException("You are trying to break singleton pattern.");
	}
}
```

2. Using enum instead of class
```java
public enum Logger {
    INSTANCE;

	private static final String RESET = "\u001B[0m";
    private static final String INFO_COLOR = "\u001B[34m"; // Blue
    private static final String DEBUG_COLOR = "\u001B[32m"; // Green
    private static final String ERROR_COLOR = "\u001B[31m"; // Red

	public void log(LogLevel level, String message) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String timestamp = now.format(formatter);

        String logEntry = switch (level) {
            case INFO -> INFO_COLOR + "[" + timestamp + "] INFO: " + message + RESET;
            case DEBUG -> DEBUG_COLOR + "[" + timestamp + "] DEBUG: " + message + RESET;
            case ERROR -> ERROR_COLOR + "[" + timestamp + "] ERROR: " + message + RESET;
        };

        System.out.println(logEntry);
    }
}
```

#### 2. Deserialization
```java
Logger logger1 = Logger.getInstance();

logger1.log(LogLevel.INFO,  "" + logger1.hashCode());

try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("abc.ob"))) {
    oos.writeObject(logger1);
}

logger1.log(LogLevel.DEBUG, "Serialization Done...");

Logger logger2;
try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("abc.ob"))) {
	logger2 = (Logger) ois.readObject();
}

logger2.log(LogLevel.INFO, "" + logger2.hashCode());
```

**Output**
```
[10-10-2024 15:57:02] INFO: 1175962212
[10-10-2024 15:57:02] DEBUG: Serialization Done...
[10-10-2024 15:57:02] INFO: 277630005
```

**Solution**
1. Implementing readResolve() method in the class
```java
public Object readResolve(){
	return instance;
}
```

#### 3. Object Cloning
```java
// Main.java
Logger logger1 = Logger.getInstance();

logger1.log(LogLevel.INFO,  "" + logger1.hashCode());

Logger logger2 = (Logger) logger1.clone();

logger2.log(LogLevel.INFO, "" + logger2.hashCode());
```

```java
// Logger.java
@Override
public Object clone() throws CloneNotSupportedException{
	return super.clone();
}
```

**Output**
```
[10-10-2024 16:07:53] INFO: 1175962212
[10-10-2024 16:07:53] INFO: 258952499
```

**Solution**
```java
// Return the same instance in clone method
@Override
public Object clone() throws CloneNotSupportedException{
	return instance;
}
```