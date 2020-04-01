package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

//Caserie magazin cu baza de date.
//Primele 6 comenzi sunt pentru administrator, daca doreste sa aduca produse noi in magazin, sa verifice bonurile, sa caute etc
//De la 7-12 sunt pentru client
public class Main {

    public static void main(String[] args) {
        int choice;
        boolean check;
        Servicii Service = new Servicii();
        System.out.println("---------------LISTA DE PRODUSE IN MAGAZIN--------------\n----------Lista Legume/Fructe din taraba---------\n");
        Service.ShowHashFruitLegume();
        System.out.println("---------------LISTA NON-LEGUME-FRUCTE-------------\n");
        Service.ShowListOtherProducts();
        System.out.println("Alege o optiune:");
        Scanner in = new Scanner(System.in);

        Service.MainMenu();
        choice = 0;
        while (choice != 12) {
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    check = false;
                    while (check != true)
                        try {
                            Service.AddFruitLegume();
                            check = true;
                        } catch (InvalidDataException e) {
                            System.out.println(e);
                        }
                    break;
                case 2:
                    check = false;
                    while (check != true)
                        try {
                            Service.AddOtherProduct();
                            check = true;
                        } catch (InvalidDataException e) {
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
                    } catch (InvalidDataException e) {
                        System.out.println(e);
                        Service.MainMenu();
                    }
                    break;
                case 6:
                    try {
                        Service.RichClients();
                    } catch (InvalidDataException e) {
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
                        } catch (InvalidDataException e) {
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
                        } catch (InvalidDataException e) {
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



