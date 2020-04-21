package com.company;

class Card extends MetodaPlata implements CsvSerializable {
    private String Nume;
    private Double Pret;

    Card(Double Pret, String Nume) {
        super(Pret);
        this.Nume = Nume;
        SetName(Nume);
    }
    Card(){}

    @Override
    public void Show() {
        super.Show();
        System.out.println("Card.\nNumele este " + this.Nume);
    }

    @Override
    public String toString() {
        String s="Numele este " + this.Nume;
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