### Prototype Design Pattern

1. Cloning of an existing object instead of creating new one and can also be customized as per the requirement.
2. It reduces the need of sub-classing.
3. It hides complexities of creating objects.
4. The clients can get new objects without knowing which type of object it will be.
5. It lets you add or remove objects at runtime.

#### Usage

1. When the classes are instantiated at runtime.
2. When the cost of creating an object is expensive or complicated.
3. When you want to keep the number of classes in an application minimum.
4. When the client application needs to be unaware of object creation and representation.

#### Implementation

NetworkConnection.java
```java
public class NetworkConnection implements Cloneable {
    private String ip;
    private String data;
    private List<String> domains = new ArrayList<>();

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<String> getDomains() {
        return domains;
    }

    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    public void loadImportantData() throws InterruptedException {
        this.data = "Very very important data";
        this.domains.add("www.google.com");
        this.domains.add("www.bing.com");
        this.domains.add("www.yahoo.com");
        Thread.sleep(5000);
    }

    @Override
    public String toString() {
        return "NetworkConnection{" +
                "ip='" + ip + '\'' +
                ", data='" + data + '\'' +
                ", domains=" + domains +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        NetworkConnection connection = new NetworkConnection();
        connection.setIp(this.getIp());
        connection.setData(this.getData());

        for (String domain: this.getDomains()){
            connection.getDomains().add(domain);
        }

        return connection;
    }
}
```

Main.java
```java
public class Main {
    public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {
        NetworkConnection connection1 = new NetworkConnection();
        connection1.setIp("168.192.8.1");
        connection1.loadImportantData();

        System.out.println(connection1);

        NetworkConnection connection2 = (NetworkConnection) connection1.clone();
        System.out.println(connection2);
        
        NetworkConnection connection3 = (NetworkConnection) connection1.clone();
        System.out.println(connection3);
    }
}
```