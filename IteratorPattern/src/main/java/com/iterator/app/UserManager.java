package com.iterator.app;

import java.util.ArrayList;
import java.util.List;

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
