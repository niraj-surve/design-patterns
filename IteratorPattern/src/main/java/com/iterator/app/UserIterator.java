package com.iterator.app;

import java.util.ArrayList;
import java.util.List;

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
