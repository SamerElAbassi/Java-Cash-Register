package com.company;

class TicheteMasa extends MetodaPlata implements CsvSerializable{
    String Nume, CNP;
    Double Pret;

    TicheteMasa(Double Pret, String Nume, String CNP) {
        super(Pret);
        SetName(Nume);
        this.Nume = Nume;
        this.CNP = CNP;
    }
    TicheteMasa(){}
    @Override
    public void Show() {
        super.Show();
        System.out.println("TicheteMasa.\nNumele este:" + this.Nume + "\nCnp-ul este:" + this.CNP);
    }

    @Override
    public String toString() {
        String s="Numele este:" + this.Nume + "\nCnp-ul este:" + this.CNP;
        return s;
    }

    @Override
    public String[] toStringArray() {
        return new String[]{Nume,Double.toString(Pret),CNP};
    }

    @Override
    public void fromStringArray(String[] data) {
        Nume=data[0];
        Pret=Double.parseDouble(data[1]);
        CNP=data[2];
    }

    @Override
    public String[] getColumnNames() {
        return new String[]{"Nume","Pret","CNP"};
    }
}
