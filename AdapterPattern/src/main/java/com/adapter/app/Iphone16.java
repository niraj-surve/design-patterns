package com.adapter.app;

public class Iphone16 {

    private AppleCharger appleCharger;

    public Iphone16(AppleCharger appleCharger) {
        this.appleCharger = appleCharger;
    }

    public void charge(){
        appleCharger.chargeIphone();
    }
}
