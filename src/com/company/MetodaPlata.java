package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MetodaPlata {
    private double Pret;
    private String CNP;
    private String Nume;

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
}


