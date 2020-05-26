package com.company;

public class Aliment implements Comparable<Aliment>, CsvSerializable {
    private String name;
    private double price;
    private int quantity = 1;

    public Aliment() {
    }

    public Aliment(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    double getPrice() {
        return price;
    }

    int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Aliment p) {
        if (this.getPrice() > p.getPrice())
            return 1;
        if (this.getPrice() < p.getPrice())
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        String s = "name=" + name + "------>" + price + "Lei";
        return s;
    }

    @Override
    public String[] toStringArray() {
        return new String[]{name, Double.toString(price)};
    }

    @Override
    public void fromStringArray(String[] data) {
        name = data[0];
        price = Double.parseDouble(data[1]);
    }

    @Override
    public String[] getColumnNames() {
        return new String[]{"name", "price"};
    }

}


