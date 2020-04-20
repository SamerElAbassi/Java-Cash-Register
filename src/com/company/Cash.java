package com.company;

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