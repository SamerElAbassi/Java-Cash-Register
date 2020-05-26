package com.company;

class Card extends paymentMethod implements CsvSerializable {
    private String name;
    private Double price;
    public Card(){}
    Card(Double price, String name) {
        super(price);
        this.name = name;
        SetName(name);
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Card.\nnamele este " + this.name);
    }

    @Override
    public String toString() {
        String s="namele este " + this.name;
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