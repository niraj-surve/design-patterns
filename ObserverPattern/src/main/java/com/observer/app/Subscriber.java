package com.observer.app;

public class Subscriber implements Observer{
    private String name;

    public Subscriber(String name){
        this.name = name;
    }

    @Override
    public void notify(String title) {
        System.out.println("Hey " + name + ", New Video Uploaded: " + title);
    }
}
