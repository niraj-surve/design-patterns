### Builder Design Pattern

1. Construct a complex object from simple objects using step-by-step approach.
2. It provides clear separation between the construction and representation of an object.
3. It provides better control over construction process.
4. It supports to change the internal representation of objects.

#### Usage

1. It is mostly used when object can't be created in single step like in the de-serialization of a complex object.

#### Implementation

User.java
```java
public class User {
    private final long id;
    private final String name;
    private final String email;

    private User(UserBuilder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static class UserBuilder{
        private long id;
        private String name;
        private String email;

        public UserBuilder(){}

        public static UserBuilder builder(){
            return new UserBuilder();
        }

        public UserBuilder setId(long id) {
            this.id = id;
            return this;
        }

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
```

Main.java
```java
public class Main {
    public static void main(String[] args) {
        User user = User.UserBuilder
                .builder()
                .setId(1)
                .setName("Niraj")
                .setEmail("niraj@gmail.com")
                .build();
        System.out.println(user);
    }
}
```