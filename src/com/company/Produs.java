package com.company;

public class Produs implements Comparable<Produs> {
    private String Nume;
    private double Pret;
    private int Cantitate = 1;
    public Produs(){

    }

    public Produs(String Nume, double Pret) {
        this.Nume = Nume;
        this.Pret = Pret;
    }

    public String GetNume() {
        return this.Nume;
    }

    double GetPret() {
        return this.Pret;
    }

    public void SetNume(String Nume){this.Nume=Nume;}

    public void SetCantitate(int Cantitate) {
        this.Cantitate = Cantitate;
    }

    void SetPret(double Pret) {
        this.Pret = Pret;
    }

    int GetCantinate() {
        return this.Cantitate;
    }

    public void Show() {
        System.out.println("Nume=" + this.Nume + "------>" + this.Pret + "Lei" + " Cantinatea este:" + this.Cantitate);
    }

    public void Show1() {
        System.out.print("Nume=" + this.Nume + "------>" + this.Pret + "Lei" + "\r");
    }


    @Override
    public int compareTo(Produs p) {
        if (this.GetPret() > p.GetPret())
            return 1;
        if (this.GetPret() < p.GetPret())
            return -1;
        return 0;
    }
}


