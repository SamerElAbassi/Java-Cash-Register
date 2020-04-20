package com.company;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Bon {
    LocalDateTime Data = LocalDateTime.now(); // Create a date object
    double Pret;
    MetodaPlata MetodaPlata;
    static int id = 0;
    int Cantitate;
    List<Produs> cos = new ArrayList<>();

    Bon() {
    }

    Bon(double Pret, MetodaPlata MetodaPlata) {
        this.Pret = Pret;
        this.MetodaPlata = MetodaPlata;
        this.Data = Data;
    }

    void SetMetodaPlata(MetodaPlata MetodaPlata) {
        this.MetodaPlata = MetodaPlata;
    }

    public double GetPret() {
        return this.Pret;
    }

    public void Add(Produs p) {
        int OK = 0;
        for (Produs element : cos) {
            if (element.GetNume().equalsIgnoreCase(p.GetNume())) {
                element.SetCantitate(element.GetCantinate() + 1);
                OK++;

            }
        }
        if (OK == 0)
            cos.add(p);
        this.Pret += p.GetPret() * p.GetCantinate();
    }

    public void Add(FructeLegume p) {
        int OK = 0;
        for (Produs element : cos) {
            if (element.GetNume().equalsIgnoreCase(p.GetNume())) {
                element.SetCantitate(element.GetCantinate());
                OK++;

            }
        }
        if (OK == 0)
            cos.add(p);
        this.Pret += p.GetPret() * p.GetCantinate();
    }


    public String GetName() {
        return this.MetodaPlata.GetName();
    }

    public void Show() {
        for (Produs element : cos) {
            element.Show();
        }
        System.out.println("\nPretul total este:" + this.Pret + ". Data este:" + this.Data);
        this.MetodaPlata.Show();


    }
}
