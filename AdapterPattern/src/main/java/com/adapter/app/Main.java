package com.adapter.app;

public class Main {
    public static void main(String[] args) {

        AndroidCharger androidCharger = new TypeCCharger();

        AppleCharger appleCharger = new Light2CAdapter(androidCharger);

        Iphone16 iphone = new Iphone16(appleCharger);

        iphone.charge();

    }
}
