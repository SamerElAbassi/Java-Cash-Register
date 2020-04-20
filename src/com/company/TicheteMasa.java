package com.company;

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
