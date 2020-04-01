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

class Cash extends MetodaPlata {
    private double Pret;
    String Nume = "A Platit Cash";

    Cash(double Pret) {
        super(Pret);
        this.SetName(Nume);
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Cash");
    }

}

class Card extends MetodaPlata {
    private String Nume;

    Card(Double Pret, String Nume) {
        super(Pret);
        this.Nume = Nume;
        SetName(Nume);
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Card.\nNumele este " + this.Nume);
    }


}

class TicheteMasa extends MetodaPlata {
    String Nume, CNP;

    TicheteMasa(Double Pret, String Nume, String CNP) {
        super(Pret);
        SetName(Nume);
        this.Nume = Nume;
        this.CNP = CNP;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("TicheteMasa.\nNumele este:" + this.Nume + "\nCnp-ul este:" + this.CNP);
    }
}