package com.observer.app;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Subject {
    private List<Observer> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        this.subscribers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        this.subscribers.remove(observer);
    }

    @Override
    public void uploadNewVideo(String title) {
        for(Observer observer: this.subscribers){
            observer.notify(title);
        }
    }
}
