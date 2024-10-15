package com.adapter.app;

public class LightCharger implements AppleCharger{
    @Override
    public void chargeIphone() {
        System.out.println("Charging Iphone with lightning cable!");
    }
}
