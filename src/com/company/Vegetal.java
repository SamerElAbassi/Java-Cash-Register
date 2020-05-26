package com.company;

class Vegetal extends Aliment implements CsvSerializable {
    double Gramaj, Cantinate;
    String name;
    Double price;
    static int id = 0;

    public Vegetal() {
        this.id++;
    }

    Vegetal(String name, double price) {
        super(name, price);
        id++
        this.id = id

    }

    public int getId() {
        return this.id;
    }

    public String getName()

    @Override
    public String toString() {
        String s = "name=" + name + "------>" + price + "Lei" + "/Kg";
        return s;
    }

    @Override
    public String[] toStringArray() {
        return new String[]{name, Double.toString(price)};
    }

    @Override
    public void fromStringArray(String[] data) {
        //Key=Integer.parseInt(data[0]);
        name = data[0];
        price = Double.parseDouble(data[1]);
    }

    @Override
    public String[] getColumnNames() {
        //return new String[]{"Id","name","price"};
        return new String[]{"name", "price"};
    }

}