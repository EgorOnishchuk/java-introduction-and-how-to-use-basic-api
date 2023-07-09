package ru.geekbrains;

public class PhoneNum {

    final String plus = "+";
    String country;
    String region;
    String subscriber;

    public PhoneNum(String country, String region, String subscriber) {
        this.country = country;
        this.region = region;
        this.subscriber = subscriber;
    }

    @Override
    public String toString() {
        return String.format("%s%s (%s) %s", plus, country, region, subscriber);
    }
    
}
