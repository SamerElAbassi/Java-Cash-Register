package com.company;

class FructeLegume extends Produs {
    double Gramaj, Cantinate;
    static int Key = 0;

    FructeLegume(String Nume, double Pret) {
        super(Nume, Pret);
        Key++;
        this.Key = Key;

    }

    int getKey() {
        return this.Key;
    }

}