package com.company;

public class Produs implements Comparable<Produs>, CsvSerializable {
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
        return Nume;
    }

    double GetPret() {
        return Pret;
    }

    public void SetNume(String Nume){Nume=Nume;}

    public void SetCantitate(int Cantitate) {
        Cantitate = Cantitate;
    }

    void SetPret(double Pret) {
        Pret = Pret;
    }

    int GetCantinate() {
        return Cantitate;
    }

    public void Show() {
        System.out.println("Nume=" + Nume + "------>" + Pret + "Lei" + " Cantinatea este:" + Cantitate);
    }

    public void Show1() {
        System.out.print("Nume=" + Nume + "------>" + Pret + "Lei" + "\r");
    }


    @Override
    public int compareTo(Produs p) {
        if (this.GetPret() > p.GetPret())
            return 1;
        if (this.GetPret() < p.GetPret())
            return -1;
        return 0;
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


