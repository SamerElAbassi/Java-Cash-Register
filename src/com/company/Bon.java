package com.company;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Bon {
    LocalDateTime data = LocalDateTime.now(); // Create a date object
    double price;
    paymentMethod paymentMethod;
    static int id = 0;
    int quantity;
    List<Aliment> cos = new ArrayList<>();

    Bon() {
    }

    Bon(double price, paymentMethod paymentMethod) {
        this.price = price;
        this.paymentMethod = paymentMethod;
        this.data = data;
    }

    void SetpaymentMethod(paymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double Getprice() {
        return this.price;
    }

    public void Add(Aliment p) {
        int OK = 0;
        for (Aliment element : cos) {
            if (element.getName().equalsIgnoreCase(p.getName())) {
                element.setQuantity(element.getQuantity() + 1);
                OK++;

            }
        }
        if (OK == 0)
            cos.add(p);
        this.price += p.getPrice() * p.getQuantity();
    }

    public void Add(Vegetal p) {
        int OK = 0;
        for (Aliment element : cos) {
            if (element.Getname().equalsIgnoreCase(p.Getname())) {
                element.setQuantity(element.getQuantity());
                OK++;

            }
        }
        if (OK == 0)
            cos.add(p);
        this.price += p.getPrice() * p.getQuantity();
    }


    public String getName() {
        return this.paymentMethod.getName();
    }

    public void Show() {
        for (Aliment element : cos) {
            element.Show();
        }
        System.out.println("\npriceul total este:" + this.price + ". data este:" + this.data);
        this.paymentMethod.Show();


    }
}
