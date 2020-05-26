package com.company;

class Cash extends paymentMethod{
    private double price;
    String name = "A Platit Cash";

    Cash(double price) {
        super(price);
        this.SetName(name);
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Cash");
    }


}