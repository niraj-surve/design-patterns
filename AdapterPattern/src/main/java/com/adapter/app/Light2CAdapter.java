package com.adapter.app;

public class Light2CAdapter implements AppleCharger {

    private AndroidCharger androidCharger;

    public Light2CAdapter(AndroidCharger androidCharger) {
        this.androidCharger = androidCharger;
    }

    @Override
    public void chargeIphone() {
        androidCharger.chargeAndoid();
        System.out.println("Your iphone is charging via light to type c adapter.");
    }
}
