package com.builder.app;

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
