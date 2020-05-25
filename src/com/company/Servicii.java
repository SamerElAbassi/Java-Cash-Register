package com.company;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.*;

public class Servicii {
    static int Nr_bonuri = 0;
    List<FructeLegume> ListFructeLegume = new ArrayList<>();

    {
    }

    List<Card> ListCard = new ArrayList<>();
    List<TicheteMasa> ListTichete = new ArrayList<>();
    int cantitate, Id, x;
    Map<Integer, FructeLegume> HashLegFructe = new HashMap();

    {
    }

    List<Produs> ListOtherProducts = new ArrayList<>();

    {

    }

    List<Bon> Bonuri = new ArrayList<>();
    Bon BonParticular = new Bon();
    String allFiles[] = {"src/com/baza_date/Produs.csv", "src/com/baza_date/FructeLegume.csv",
            "src/com/baza_date/Card.csv", "src/com/baza_date/TicheteMasa.csv"};

    void Citiri(String filePath) {
        try {
            FileReader file = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(file);
            String simpleClassName = filePath.substring(18, filePath.length() - 4);
            String className = "com.company." + simpleClassName;

            System.out.println("-------------SE DESCHIDE---------" + simpleClassName + ".csv");

            Class<?> clazz = Class.forName(className);
            Constructor<?> ctor = clazz.getConstructor();
            Object object = ctor.newInstance(new Object[]{});
            var v = object.getClass().cast(object);


            CsvReader Reader = new CsvReader(reader, (CsvSerializable) object);
            while (Reader.hasMoreObjects()) {
                v = Reader.readObject((CsvSerializable) v);
                System.out.println(v);

            }
            ////N-a mers castu de niciun fel
            /*
            switch (simpleClassName) {
                case "Produs":
                    Reader = new CsvReader(reader, (Produs) (object));
                    while (Reader.hasMoreObjects()) {
                        ListOtherProducts.add((Produs) Reader.readObject((Produs) object));
                        object = ctor.newInstance(new Object[]{});
                    }

                    break;
                case "FructeLegume":
                    Reader = new CsvReader(reader, (FructeLegume) object);
                    while (Reader.hasMoreObjects()) {
                        {
                            ;
                            ListFructeLegume.add((FructeLegume) Reader.readObject((FructeLegume) object));
                            int index = ListFructeLegume.size() - 1;
                            FructeLegume p = ListFructeLegume.get(index);

                            //
                            //
                            //System.out.println(p);
                            HashLegFructe.put(index, p);
                            object = ctor.newInstance(new Object[]{});
                        }
                    }
                    break;
                case "Card":
                    Reader = new CsvReader(reader, (Card) (object));
                    while (Reader.hasMoreObjects()) {
                        {
                            ListCard.add((Card) Reader.readObject((Card) object));
                            object = ctor.newInstance(new Object[]{});
                        }
                    }
                    break;
                case "TicheteMasa":
                    Reader = new CsvReader(reader, (TicheteMasa) (object));
                    while (Reader.hasMoreObjects()) {
                        ListTichete.add((TicheteMasa) Reader.readObject((TicheteMasa) object));
                        object = ctor.newInstance(new Object[]{});
                    }
                    break;
            }
            reader.close();
            file.close();

             */
        } catch (Exception e) {
            System.out.println(e);
        }

    }


    void Scrieri(String filePath, Object object) {
        try {
            FileWriter file = new FileWriter(filePath, true);
            BufferedWriter writer = new BufferedWriter(file);
            String simpleClassName = filePath.substring(18, filePath.length() - 4);
            String className = "com.company." + simpleClassName;
            Class<?> clazz = Class.forName(className);
            Constructor<?> ctor = clazz.getConstructor();
            object = ctor.newInstance(new Object[]{});
            CsvWriter Writer;
            ////N-a mers cast cu <T> de niciun fel de niciun fel
            /*switch (simpleClassName) {
                case "Produs":
                    Writer = new CsvWriter(writer, (Produs) (object));
                    Writer.writeObject((Produs) object);
                    break;
                case "FructeLegume":
                    Writer = new CsvWriter(writer, (Produs) (object));
                    Writer.writeObject((FructeLegume) object);
                    break;
                case "Card":
                    Writer = new CsvWriter(writer, (Produs) (object));
                    Writer.writeObject((Card) object);
                    break;
                case "TicheteMasa":
                    Writer = new CsvWriter(writer, (Produs) (object));
                    Writer.writeObject((TicheteMasa) object);

            }
            writer.close();
            file.close();*/
        } catch (Exception e) {
            System.out.println(e);
        }

    }


    void AddFruitLegume() throws InvalidDataException {
        int id;
        String Nume;
        double Pret;
        //Citire3

        System.out.println("Scrie numele");
        Scanner in = new Scanner(System.in);
        Nume = in.nextLine();
        for (FructeLegume element : ListFructeLegume)
            if (element.GetNume().equalsIgnoreCase(Nume))
                throw new InvalidDataException("Exista deja produsul!");
        System.out.print("Scrie pretul/kg");
        try {
            Pret = in.nextDouble();
            FructeLegume Fruct = new FructeLegume(Nume, Pret);
            id = Fruct.getKey();
            HashLegFructe.put(id, Fruct);
            ListFructeLegume.add(Fruct);
        } catch (InputMismatchException e) {
            System.err.println("Nu ai introdus un numar!");
        }

        MainMenu();
    }

    void AddOtherProduct() throws InvalidDataException {
        String Nume;
        double Pret;
        //Citire

        System.out.println("Scrie numele produsului: ");
        Scanner in = new Scanner(System.in);
        Nume = in.nextLine();
        System.out.println("Scrie Pretul produsului: ");

        try {
            Pret = in.nextDouble();
            Produs Product = new Produs(Nume, Pret);
            for (Produs element : ListOtherProducts)
                if (element.GetNume().equalsIgnoreCase(Nume))
                    throw new InvalidDataException("Exista deja produsul!");
            ListOtherProducts.add(Product);
        } catch (InputMismatchException e) {
            System.err.println("Nu ai introdus un numar!");
        }

        //

        MainMenu();
    }

    protected void ShowHashFruitLegume() {
        for (Map.Entry<Integer, FructeLegume> entry : HashLegFructe.entrySet()) {
            System.out.println("Id leg/fructe:" + entry.getKey() + " Numele este:" + entry.getValue().GetNume() + " Pret=" + entry.getValue().GetPret() + "/kg");
            // do stuff
        }
    }

    protected void ShowListFruitLegume() {
        for (FructeLegume element : ListFructeLegume)
            System.out.println(element);
        MainMenu();
    }

    protected void ShowListOtherProducts() {
        for (Produs element : ListOtherProducts) {
            System.out.println(element);
        }

    }

    void SortProducts() {

        Collections.sort(ListOtherProducts);
        ShowListOtherProducts();
        MainMenu();

    }

    void FindClient() throws InvalidDataException {
        String Nume;
        //Citire

        System.out.println("Scrie numele");
        Scanner in = new Scanner(System.in);
        Nume = in.nextLine();
        int OK = 0;
        for (Bon e : Bonuri)
            if (e.GetName().equalsIgnoreCase(Nume)) {
                e.Show();
                OK++;
            }
        if (OK == 0) {
            throw new InvalidDataException("Nu exista clientul cu acest nume!");
        }
        MainMenu();
    }


    void RichClients() throws InvalidDataException {
        double x;
        //Citire
        int ok1 = 0;
        System.out.println("Scrie suma minima");
        Scanner in = new Scanner(System.in);
        try {
            x = in.nextInt();
            for (Bon element : Bonuri)
                if (element.GetPret() > x) {
                    element.Show();
                    ok1 = 1;
                }
        } catch (InputMismatchException e) {
            System.err.println("Nu ai introdus un numar!");
        }

        if (ok1 == 0)
            throw new InvalidDataException("Nu exista!");

        MainMenu();
    }

    void AddProductCos() throws InvalidDataException {
        SecondMenu();
        Scanner in = new Scanner(System.in);
        int choice = 0;
        while (choice != 3) {
            choice = in.nextInt();
            if (choice > 3)
                throw new InvalidDataException("Optiunea este intre 1-3!");
            switch (choice) {
                case 1:
                    AddLegFruitCos();
                    break;
                case 2:
                    AddAltProductCos();
                    break;
                default:
                    break;
            }
        }
        MainMenu();
    }

    void AddLegFruitCos() throws InvalidDataException {
        ShowHashFruitLegume();
        Scanner in = new Scanner(System.in);
        System.out.println("Scrie Id-ul");
        try {
            Id = in.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Nu ai introdus un numar!");
        }
        if (!HashLegFructe.containsKey(Id))
            throw new InvalidDataException("Id inexistent!");
        for (Map.Entry<Integer, FructeLegume> entry : HashLegFructe.entrySet()) {
            if (entry.getKey() == Id) {
                System.out.print("Scrie Gramajul (in kg)");
                try {
                    cantitate = in.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Nu ai introdus un numar!");
                }
                for (FructeLegume element : ListFructeLegume)
                    if (element.GetNume().equalsIgnoreCase(entry.getValue().GetNume())) {
                        element.SetCantitate(cantitate);
                        BonParticular.Add(element);
                    }


            }
        }

        // do stuff
        SecondMenu();


    }

    void AddAltProductCos() throws InvalidDataException {
        int ok = 0;
        ShowListOtherProducts();
        Scanner in = new Scanner(System.in);
        System.out.println("Scrie Numele");
        String Nume = in.nextLine();
        for (Produs element : ListOtherProducts)
            if (element.GetNume().equalsIgnoreCase(Nume)) {
                System.out.print("Scrie Cantinatea:");
                try {
                    cantitate = in.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Nu ai introdus un numar!");
                }
                element.SetCantitate(cantitate);
                BonParticular.Add(element);
                ok = 1;
            }
        if (ok == 0)
            throw new InvalidDataException("Nu exista produsul cu acest nume!");

        SecondMenu();

    }

    void PayCash() {
        if (BonParticular.GetPret() == 0)
            System.out.println("Nu ai inca produse in cos!");

        else {
            System.out.println("Pretul este:" + BonParticular.GetPret());
            Cash Plata = new Cash(BonParticular.GetPret());
            BonParticular.SetMetodaPlata(Plata);
            System.out.println("\nAchitat! Se elibereaza cosul!\n");
            BonParticular.MetodaPlata = Plata;
            Bonuri.add(BonParticular);
            BonParticular = new Bon();
            Nr_bonuri++;
        }
        MainMenu();


    }

    void PayCard() {
        if (BonParticular.GetPret() == 0)
            System.out.println("Nu ai inca produse in cos!");
        else {
            System.out.println("Pretul este " + BonParticular.GetPret());
            System.out.println("Scrie numele:");
            Scanner in = new Scanner(System.in);
            String Nume = in.nextLine();
            Card Plata = new Card(BonParticular.GetPret(), Nume);
            System.out.println("\nAchitat! Se elibereaza cosul!\n");
            BonParticular.MetodaPlata = Plata;
            Bonuri.add(BonParticular);
            BonParticular = new Bon();
            Nr_bonuri++;
        }
        MainMenu();


    }

    void PayTichete() throws InvalidDataException {
        if (BonParticular.GetPret() == 0)
            System.out.println("Nu ai inca produse in cos!");
        else {
            System.out.println("Pretul este " + BonParticular.GetPret());
            System.out.println("Scrie numele:");
            Scanner in = new Scanner(System.in);
            String Nume = in.nextLine();
            System.out.println("Scrie CNP");
            String CNP = in.nextLine();
            if (CNP.length() != 12)
                throw new InvalidDataException("CNP-ul nu are 13 cifre!");
            BonParticular.MetodaPlata = new TicheteMasa(BonParticular.GetPret(), Nume, CNP);

            System.out.println("\nAchitat! Se elibereaza cosul!\n");
            Bonuri.add(BonParticular);
            BonParticular = new Bon();
            Nr_bonuri++;
        }
        MainMenu();

    }

    void SeeCos() {
        for (Produs e : BonParticular.cos)
            e.Show();
        System.out.println("\n");
        MainMenu();

    }

    void SeeBonuri() {


        for (Bon e : Bonuri) {
            System.out.println("----------BON NOU-----------");
            e.Show();
        }

        MainMenu();
    }

    void MainMenu() {
        System.out.println("\n1.Adauga legume/fructe in lista de produse(as admin)\n" +
                "2.Adauga alt tip de produs in lista de produse(as admin)\n" +
                "3.Vezi Bonurile\n" +
                "4.Sorteaza produsele(fara id) dupa pret\n" +
                "5.Cauta bonul unui client dupa nume\n" +
                "6.Afiseaza clientii cu suma mai mare decat x\n" +
                "7.Adauga un produs in cos\n" +
                "8.Plateste Cash\n" +
                "9.Plateste Card\n" +
                "10.Plateste cu Tichete\n" +
                "11.Vezi Cos\n" +
                "12.exit");
    }

    void SecondMenu() {
        System.out.println("Este leguma/fruct sau altceva?" +
                "\n1.Leguma/Fruct" + "\n2.Altceva" + "\n3.Exit");
    }


}





