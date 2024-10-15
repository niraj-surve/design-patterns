package com.iterator.app;

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
