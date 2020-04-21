package com.company;

public class MetodaPlata {
    private double Pret;
    private String CNP;
    private String Nume;
    MetodaPlata(){}

    void SetName(String Nume) {
        this.Nume = Nume;
    }

    MetodaPlata(double Pret) {
        this.Pret = Pret;
    }

    protected void Show() {
        System.out.println("Metoda de plata este:");
    }

    public String GetName() {
        return this.Nume;
    }
    @Override
    public String toString() {
        String s="Metoda de plata este:";
        return s;
    }
}


