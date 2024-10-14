package com.observer.app;

public interface Subject {
    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    void uploadNewVideo(String title);
}
