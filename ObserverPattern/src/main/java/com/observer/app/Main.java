package com.observer.app;

public class Main {
    public static void main(String[] args) {
        YoutubeChannel channel = new YoutubeChannel();

        Subscriber ram = new Subscriber("Ram");
        Subscriber shyam = new Subscriber("Shyam");

        channel.subscribe(ram);
        channel.subscribe(shyam);

        channel.uploadNewVideo("One Piece");
    }
}
