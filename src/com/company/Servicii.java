package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Servicii {
    static int Nr_bonuri = 0;
    List<FructeLegume> ListFructeLegume = new ArrayList<>();

    {
        ListFructeLegume.add(new FructeLegume("Avocado", 50));
        ListFructeLegume.add(new FructeLegume("Portocale", 20));
        ListFructeLegume.add(new FructeLegume("Mere", 70));
        ListFructeLegume.add(new FructeLegume("Rosii", 25));

    }

    int cantitate, Id, x;
    Map<Integer, FructeLegume> HashLegFructe = new HashMap();

    {
        HashLegFructe.put(1, ListFructeLegume.get(0));
        HashLegFructe.put(2, ListFructeLegume.get(1));
        HashLegFructe.put(3, ListFructeLegume.get(2));
        HashLegFructe.put(4, ListFructeLegume.get(3));


    }

    List<Produs> ListOtherProducts = new ArrayList<>();

    {
        ListOtherProducts.add(new Produs("Detergent", 20));
        ListOtherProducts.add(new Produs("Spirt", 40));
        ListOtherProducts.add(new Produs("Apa", 5));
        ListOtherProducts.add(new Produs("Hartie", 15));

    }

    List<Bon> Bonuri = new ArrayList<>();
    Bon BonParticular = new Bon();
    String allFiles[] = {"src/com/baza_date/Produs.csv", "src/com/baza_date/FructeLegume.csv",
            "src/com/baza_date/Card.csv", "src/com/baza_date/TicheteMasa.csv"};

    void Citiri() {
        for (String filePath : allFiles) {
            try {
                FileReader file = new FileReader(filePath);
                BufferedReader reader = new BufferedReader(file);
                if (filePath.equalsIgnoreCase("src/com/baza_date/Produs.csv")) {
                    System.out.println("---------------------");
                    System.out.println("Deschidem Produs.csv:");
                    System.out.println("---------------------");

                    var obiect = new Produs();
                    CsvReader Reader = new CsvReader(reader, obiect);
                    while (Reader.hasMoreObjects()) {
                        Reader.readObject(obiect);
                        System.out.println(obiect);
                    }
                }
                if (filePath.equalsIgnoreCase("src/com/baza_date/FructeLegume.csv")) {
                    System.out.println("---------------------");
                    System.out.println("Deschidem FructeLegume.csv");
                    var obiect = new FructeLegume();
                    System.out.println("---------------------");

                    CsvReader Reader = new CsvReader(reader, obiect);
                    while (Reader.hasMoreObjects()) {
                        Reader.readObject(obiect);
                        System.out.println(obiect);
                    }
                }
                if (filePath.equalsIgnoreCase("src/com/baza_date/Card.csv")) {
                    System.out.println("---------------------");
                    System.out.println("Deschidem Card.csv");
                    System.out.println("---------------------");

                    var obiect = new Card();
                    CsvReader Reader = new CsvReader(reader, obiect);
                    while (Reader.hasMoreObjects()) {
                        Reader.readObject(obiect);
                        System.out.println(obiect);
                    }
                }
                if (filePath.equalsIgnoreCase("src/com/baza_date/TicheteMasa.csv")) {
                    System.out.println("---------------------");

                    System.out.println("Deschidem TicheteMasa.csv");
                    System.out.println("---------------------");

                    var obiect = new TicheteMasa();
                    CsvReader Reader = new CsvReader(reader, obiect);
                    while (Reader.hasMoreObjects()) {
                        Reader.readObject(obiect);
                        System.out.println(obiect);
                    }
                }
                reader.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    void Scrieri() {
        try {
            String filePath = "src/com/baza_date/Produs1.csv";
            FileWriter file = new FileWriter(filePath,true);
            BufferedWriter writer = new BufferedWriter(file);
            {
                System.out.println("---------------------");
                System.out.println("Scriem in Produs1.csv");
                System.out.println("---------------------");

                var obiect = new Produs("Mango", 50);
                CsvWriter Writer = new CsvWriter(writer, obiect);
                Writer.writeObject(obiect);

            }
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
            element.Show1();
        MainMenu();
    }

    protected void ShowListOtherProducts() {
        for (Produs element : ListOtherProducts) {
            element.Show1();
            System.out.println("\n");
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





