package com.prototype.app;

import java.util.ArrayList;
import java.util.List;

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
