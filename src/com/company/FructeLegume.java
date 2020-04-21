package com.company;

class FructeLegume extends Produs implements CsvSerializable {
    double Gramaj, Cantinate;
    String Nume;
    Double Pret;
    static int Key = 0;
    FructeLegume(){}
    FructeLegume(String Nume, double Pret) {
        super(Nume, Pret);
        Key++;
        this.Key = Key;

    }

    int getKey() {
        return this.Key;
    }

    @Override
    public String toString() {
        String s="Nume=" + this.Nume + "------>" + this.Pret + "Lei"+"/Kg";
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