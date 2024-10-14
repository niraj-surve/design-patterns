package com.prototype.app;

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
