package com.company;

public class Object1 extends Object implements CsvSerializable {
    private String Nume;
    private double Pret;
    private int Cantitate = 1;
    public Object1() {
        super();
    }

    @Override
    public String toString() {
        String s="Nume=" + Nume + "------>" + Pret + "Lei";
        return s;
    }
    @Override
    public String[] toStringArray() {
        return new String[]{Nume,Double.toString(Pret)};
    }

    @Override
    public void fromStringArray(String[] data) {
        Nume=data[0];
        Pret=Double.parseDouble(data[1]);
    }

    @Override
    public String[] getColumnNames() {
        return new String[]{"Nume","Pret"};
    }
}
