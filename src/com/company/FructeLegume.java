package com.company;

class FructeLegume extends Produs implements CsvSerializable {
    double Gramaj, Cantinate;
    String Nume;
    Double Pret;
    static int Key = 0;
    public FructeLegume(){
        this.Key++;
    }
    FructeLegume(String Nume, double Pret) {
        super(Nume, Pret);
        Key++;
        this.Key = Key;

    }

    int getKey() {
        return this.Key;
    }

    @Override
    public String toString() {
        //String s="Id="+Key+"Nume=" + Nume + "------>" +Pret + "Lei"+"/Kg";
        String s="Nume="+Nume + "------>" +Pret + "Lei"+"/Kg";

        return s;

    }

    @Override
    public String[] toStringArray() {
        //return new String[]{Integer.toString(Key),Nume,Double.toString(Pret)};
        return new String[]{Nume,Double.toString(Pret)};
    }

    @Override
    public void fromStringArray(String[] data) {
        //Key=Integer.parseInt(data[0]);
        Nume=data[0];
        Pret=Double.parseDouble(data[1]);
    }

    @Override
    public String[] getColumnNames() {
        //return new String[]{"Id","Nume","Pret"};
        return new String[]{"Nume","Pret"};
    }

}