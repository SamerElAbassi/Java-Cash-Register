package com.company;

public class paymentMethod {
    private double price;
    private String CNP;
    private String name;
    paymentMethod(){}

    void SetName(String name) {
        this.name = name;
    }

    paymentMethod(double price) {
        this.price = price;
    }

    protected void Show() {
        System.out.println("Metoda de plata este:");
    }

    public String getName() {
        return this.name;
    }
    @Override
    public String toString() {
        String s="Metoda de plata este:";
        return s;
    }
}


