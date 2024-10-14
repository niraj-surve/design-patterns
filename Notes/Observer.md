### Observer Design Pattern

1. Behavioural Design Pattern.
2. Define a one-to-one dependency so that when one object changes state, all its dependents are notified and updated automatically.
3. Also known as Dependents or Publish-Subscribe.
4. It describes the coupling between the objects and the observer.
5. It provides the support for broadcast-type communication.

#### Usage
1. When the change of a state in one object must be reflected in another object without keeping the objects tight coupled.
2. When the framework we writes and needs to be enhanced in future with new observers with minimal chamges.

#### Implementation
Subject.java
```java
public interface Subject {
    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    void uploadNewVideo(String title);
}
```

Observer.java
```java
public interface Observer {
    void notify(String title);
}
```

YoutubeChannel.java
```java
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
```

Subscriber.java
```java
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
```

Main.java
```java
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
```