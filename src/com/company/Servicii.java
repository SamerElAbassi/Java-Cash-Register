package com.company;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.*;

public class Servicii {
    static int Nr_bonuri = 0;
    List<Vegetal> ListFructeLegume = new ArrayList<>();

    {
    }

    List<Card> ListCard = new ArrayList<>();
    List<TicheteMasa> ListTichete = new ArrayList<>();
    int quantity, Id, x;
    Map<Integer, Vegetal> HashLegFructe = new HashMap();

    {
    }
    List<Aliment> ListOtherProducts = new ArrayList<>();

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


    void AddFruitLegume() throws InvaliddataException {
        int id;
        String name;
        double price;
        System.out.println("Scrie namele");
        Scanner in = new Scanner(System.in);
        name = in.nextLine();
        for (Vegetal element : ListFructeLegume)
            if (element.Getname().equalsIgnoreCase(name))
                throw new InvaliddataException("Exista deja produsul!");
        System.out.print("Scrie priceul/kg");
        try {
            price = in.nextDouble();
            Vegetal Fruct = new Vegetal(name, price);
            id = Fruct.getKey();
            HashLegFructe.put(id, Fruct);
            ListFructeLegume.add(Fruct);
        } catch (InputMismatchException e) {
            System.err.println("Nu ai introdus un numar!");
        }

        MainMenu();
    }

    void AddOtherProduct() throws InvaliddataException {
        String name;
        double price;
        //Citire

        System.out.println("Scrie namele produsului: ");
        Scanner in = new Scanner(System.in);
        name = in.nextLine();
        System.out.println("Scrie priceul produsului: ");

        try {
            price = in.nextDouble();
            Aliment Product = new Aliment(name, price);
            for (Aliment element : ListOtherProducts)
                if (element.Getname().equalsIgnoreCase(name))
                    throw new InvaliddataException("Exista deja produsul!");
            ListOtherProducts.add(Product);
        } catch (InputMismatchException e) {
            System.err.println("Nu ai introdus un numar!");
        }

        //

        MainMenu();
    }

    protected void ShowHashFruitLegume() {
        for (Map.Entry<Integer, Vegetal> entry : HashLegFructe.entrySet()) {
            System.out.println("Id leg/fructe:" + entry.getKey() + " namele este:" + entry.getValue().Getname() + " price=" + entry.getValue().getPrice() + "/kg");
            // do stuff
        }
    }

    protected void ShowListFruitLegume() {
        for (Vegetal element : ListFructeLegume)
            System.out.println(element);
        MainMenu();
    }

    protected void ShowListOtherProducts() {
        for (Aliment element : ListOtherProducts) {
            System.out.println(element);
        }

    }

    void SortProducts() {

        Collections.sort(ListOtherProducts);
        ShowListOtherProducts();
        MainMenu();

    }

    void FindClient() throws InvaliddataException {
        String name;
        //Citire

        System.out.println("Scrie namele");
        Scanner in = new Scanner(System.in);
        name = in.nextLine();
        int OK = 0;
        for (Bon e : Bonuri)
            if (e.getName().equalsIgnoreCase(name)) {
                e.Show();
                OK++;
            }
        if (OK == 0) {
            throw new InvaliddataException("Nu exista clientul cu acest name!");
        }
        MainMenu();
    }


    void RichClients() throws InvaliddataException {
        double x;
        //Citire
        int ok1 = 0;
        System.out.println("Scrie suma minima");
        Scanner in = new Scanner(System.in);
        try {
            x = in.nextInt();
            for (Bon element : Bonuri)
                if (element.Getprice() > x) {
                    element.Show();
                    ok1 = 1;
                }
        } catch (InputMismatchException e) {
            System.err.println("Nu ai introdus un numar!");
        }

        if (ok1 == 0)
            throw new InvaliddataException("Nu exista!");

        MainMenu();
    }

    void AddProductCos() throws InvaliddataException {
        SecondMenu();
        Scanner in = new Scanner(System.in);
        int choice = 0;
        while (choice != 3) {
            choice = in.nextInt();
            if (choice > 3)
                throw new InvaliddataException("Optiunea este intre 1-3!");
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

    void AddLegFruitCos() throws InvaliddataException {
        ShowHashFruitLegume();
        Scanner in = new Scanner(System.in);
        System.out.println("Scrie Id-ul");
        try {
            Id = in.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Nu ai introdus un numar!");
        }
        if (!HashLegFructe.containsKey(Id))
            throw new InvaliddataException("Id inexistent!");
        for (Map.Entry<Integer, Vegetal> entry : HashLegFructe.entrySet()) {
            if (entry.getKey() == Id) {
                System.out.print("Scrie Gramajul (in kg)");
                try {
                    quantity = in.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Nu ai introdus un numar!");
                }
                for (Vegetal element : ListFructeLegume)
                    if (element.Getname().equalsIgnoreCase(entry.getValue().Getname())) {
                        element.setQuantity(quantity);
                        BonParticular.Add(element);
                    }


            }
        }

        // do stuff
        SecondMenu();


    }

    void AddAltProductCos() throws InvaliddataException {
        int ok = 0;
        ShowListOtherProducts();
        Scanner in = new Scanner(System.in);
        System.out.println("Scrie namele");
        String name = in.nextLine();
        for (Aliment element : ListOtherProducts)
            if (element.Getname().equalsIgnoreCase(name)) {
                System.out.print("Scrie Cantinatea:");
                try {
                    quantity = in.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Nu ai introdus un numar!");
                }
                element.setQuantity(quantity);
                BonParticular.Add(element);
                ok = 1;
            }
        if (ok == 0)
            throw new InvaliddataException("Nu exista produsul cu acest name!");

        SecondMenu();

    }

    void PayCash() {
        if (BonParticular.Getprice() == 0)
            System.out.println("Nu ai inca produse in cos!");

        else {
            System.out.println("priceul este:" + BonParticular.Getprice());
            Cash Plata = new Cash(BonParticular.Getprice());
            BonParticular.SetpaymentMethod(Plata);
            System.out.println("\nAchitat! Se elibereaza cosul!\n");
            BonParticular.paymentMethod = Plata;
            Bonuri.add(BonParticular);
            BonParticular = new Bon();
            Nr_bonuri++;
        }
        MainMenu();


    }

    void PayCard() {
        if (BonParticular.Getprice() == 0)
            System.out.println("Nu ai inca produse in cos!");
        else {
            System.out.println("priceul este " + BonParticular.Getprice());
            System.out.println("Scrie namele:");
            Scanner in = new Scanner(System.in);
            String name = in.nextLine();
            Card Plata = new Card(BonParticular.Getprice(), name);
            System.out.println("\nAchitat! Se elibereaza cosul!\n");
            BonParticular.paymentMethod = Plata;
            Bonuri.add(BonParticular);
            BonParticular = new Bon();
            Nr_bonuri++;
        }
        MainMenu();


    }

    void PayTichete() throws InvaliddataException {
        if (BonParticular.Getprice() == 0)
            System.out.println("Nu ai inca produse in cos!");
        else {
            System.out.println("priceul este " + BonParticular.Getprice());
            System.out.println("Scrie namele:");
            Scanner in = new Scanner(System.in);
            String name = in.nextLine();
            System.out.println("Scrie CNP");
            String CNP = in.nextLine();
            if (CNP.length() != 12)
                throw new InvaliddataException("CNP-ul nu are 13 cifre!");
            BonParticular.paymentMethod = new TicheteMasa(BonParticular.Getprice(), name, CNP);

            System.out.println("\nAchitat! Se elibereaza cosul!\n");
            Bonuri.add(BonParticular);
            BonParticular = new Bon();
            Nr_bonuri++;
        }
        MainMenu();

    }

    void SeeCos() {
        for (Aliment e : BonParticular.cos)
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
                "4.Sorteaza produsele(fara id) dupa price\n" +
                "5.Cauta bonul unui client dupa name\n" +
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





