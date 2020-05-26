package com.company;


import com.company.Persistence.AlimentRepository;
import com.company.Persistence.CardRepository;
import com.company.Persistence.VegetalRepository;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int choice = 0;


        while (choice != 3) {
            System.out.println("Are you an admin or a client?\n1.Admin \n2.Client\n3.Exit");
            Scanner in = new Scanner(System.in);
            try {
                choice = in.nextInt();
            } catch (Exception e) {
                System.out.println(e);
            }
            if (choice == 1)
            {ServicesAdmin servicesAdmin=new ServicesAdmin();
            servicesAdmin.mainMenu();}
            if (choice == 2) {
                ServicesClient servicesClient = new ServicesClient();
                servicesClient.mainMenu();
            }

        }
        System.out.println("Exit.");

        /*while (choice != 12) {
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

    */
    }


}



