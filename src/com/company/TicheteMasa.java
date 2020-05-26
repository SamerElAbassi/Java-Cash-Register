package com.company;

class TicheteMasa extends paymentMethod implements CsvSerializable{
    String name, CNP;
    Double price;
    public TicheteMasa(){}
    TicheteMasa(Double price, String name, String CNP) {
        super(price);
        SetName(name);
        this.name = name;
        this.CNP = CNP;
    }
    @Override
    public void Show() {
        super.Show();
        System.out.println("TicheteMasa.\nnamele este:" + this.name + "\nCnp-ul este:" + this.CNP);
    }

    @Override
    public String toString() {

        return "namele este:" + this.name + "\nCnp-ul este:" + this.CNP;
    }

    @Override
    public String[] toStringArray() {
        return new String[]{name,Double.toString(price),CNP};
    }

    @Override
    public void fromStringArray(String[] data) {
        name=data[0];
        price=Double.parseDouble(data[1]);
        CNP=data[2];
    }

    @Override
    public String[] getColumnNames() {
        return new String[]{"name","price","CNP"};
    }
}
