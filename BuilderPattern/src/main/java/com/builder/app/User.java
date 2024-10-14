package com.builder.app;

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
