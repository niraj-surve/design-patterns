### Iterator Design Pattern

1. To access the elements of an aggregate object sequentially without exposing its underlying implementation.
2. Also known as Cursor.
3. It supports variations in the traversal of a collection.
4. It simplifies the interface to the collection.

#### Usage
1. When you want to access a collection of objects without exposing its internal representation.
2. When there are multiple traversals of objects need to be supported in the collection.

#### Implementation

User.java
```java
public class User {
    private long id;
    private String name;

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
```

UserManager.java
```java
public class UserManager {
    private List<User> users = new ArrayList<>();

    public void addUser(User user){
        users.add(user);
    }

    public User getUsers(int index){
        return users.get(index);
    }

    public CustomIterator getIterator(){
        return new UserIterator(users);
    }
}
```

CustomIterator.java
```java
public interface CustomIterator {
    boolean hasNext();

    Object next();
}
```

UserIterator.java
```java
public class UserIterator implements CustomIterator{
    private List<User> users;
    private int length;
    private int position = 0;

    public UserIterator(List<User> users){
        this.users = users;
        this.length = users.size();
    }

    @Override
    public boolean hasNext() {
        if (position >= length) {
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        User user = users.get(position);
        position+=1;
        return user;
    }
}
```

Main.java
```java
public class Main {
    public static void main(String[] args) {
        UserManager manager = new UserManager();
        manager.addUser(new User(1, "Niraj"));
        manager.addUser(new User(2, "Rahul"));
        manager.addUser(new User(3, "Rohit"));
        manager.addUser(new User(4, "Akshay"));
        
        CustomIterator iterator = manager.getIterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
```