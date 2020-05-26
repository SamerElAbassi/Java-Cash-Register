package com.company;
import java.util.Scanner;
public class Main {
    public static <T> T castObject(Class<T> clazz, Object object) {
        return (T) object;
    }

    public static void main(String[] args) {
        int choice;
        boolean check;
        String allFiles[] = {"src/com/baza_date/Produs.csv", "src/com/baza_date/FructeLegume.csv",
                "src/com/baza_date/Card.csv", "src/com/baza_date/TicheteMasa.csv"};
        Servicii Service = new Servicii();
        for (String filePath : allFiles) {
            Service.Citiri(filePath);
        }
        System.out.println("---------------LISTA DE PRODUSE IN MAGAZIN--------------\n----------Lista Legume/Fructe din taraba---------\n");
        Service.ShowListFruitLegume();
        System.out.println("---------------LISTA NON-LEGUME-FRUCTE-------------\n");
        Service.ShowListOtherProducts();
        System.out.println("Alege o optiune:");
        Scanner in = new Scanner(System.in);
        Logger logger = new Logger();
        Service.MainMenu();
        choice = 0;

        while (choice != 12) {
            choice = in.nextInt();
            try {
                logger.Update(choice);
            } catch (Exception e) {
                System.out.println(e);
            }
            switch (choice) {
                case 1:
                    check = false;
                    while (check != true)
                        try {
                            Service.AddFruitLegume();
                            check = true;
                        } catch (InvaliddataException e) {
                            System.out.println(e);
                        }
                    break;
                case 2:
                    check = false;
                    while (check != true)
                        try {
                            Service.AddOtherProduct();
                            check = true;
                        } catch (InvaliddataException e) {
                            System.out.println(e);
                        }
                    break;
                case 3:

                    Service.SeeBonuri();
                    break;
                case 4:
                    Service.SortProducts();
                    break;
                case 5:
                    try {
                        Service.FindClient();
                        check = true;
                    } catch (InvaliddataException e) {
                        System.out.println(e);
                        Service.MainMenu();
                    }
                    break;
                case 6:
                    try {
                        Service.RichClients();
                    } catch (InvaliddataException e) {
                        System.out.println(e);
                        Service.MainMenu();
                    }
                    break;
                case 7:
                    check = false;
                    while (check != true)
                        try {
                            Service.AddProductCos();
                            check = true;
                        } catch (InvaliddataException e) {
                            System.out.println(e);
                        }
                    break;
                case 8:
                    Service.PayCash();
                    break;
                case 9:
                    Service.PayCard();
                    break;
                case 10:
                    check = false;
                    while (check != true)
                        try {
                            Service.PayTichete();
                            check = true;
                        } catch (InvaliddataException e) {
                            System.out.println(e);
                        }
                    break;
                case 11:
                    Service.SeeCos();
                    break;
                case 12:
                    break;
                default:
                    System.out.println("Numarul invalid!");
                    Service.MainMenu();
                    break;
            }
        }


    }


}



