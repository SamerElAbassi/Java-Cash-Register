package com.company;

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