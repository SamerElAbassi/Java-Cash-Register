package com.company;

public class Object1 extends Object implements CsvSerializable {
    private String name;
    private double price;
    private int quantity = 1;
    public Object1() {
        super();
    }

    @Override
    public String toString() {
        String s="name=" + name + "------>" + price + "Lei";
        return s;
    }
    @Override
    public String[] toStringArray() {
        return new String[]{name,Double.toString(price)};
    }

    @Override
    public void fromStringArray(String[] data) {
        name=data[0];
        price=Double.parseDouble(data[1]);
    }

    @Override
    public String[] getColumnNames() {
        return new String[]{"name","price"};
    }
}
