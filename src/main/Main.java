package main;
import repository.*;
import model.*;
import service.*;

import  java.util.*;
public class Main {
    public static void main(String args[]) {
        Shop shop = new Shop();
        String input;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Ikea Menu");
            System.out.println("1. Products Menu & Delivery Menu");
            System.out.println("2. Orders Menu");
            System.out.println("3. Initialize the database");
            System.out.println("4. Delete the DataBase ");
            System.out.println("5. Exit");
            input = scanner.nextLine();
            while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5")) {
                System.out.println("Invalid input. Please enter a valid option: ");
                input= scanner.nextLine();
            }
            if (input.equals("1")) {
                shop.menu_productsAndActions();
            }
        else if (input.equals("2")) {
                shop.menu_orders();
            }
        else if (input.equals("3")) {
                shop.init();
            }
        else if (input.equals("4")) {
                actionRepository.getInstance().deleteAllActionsDB();
                deliveryRepository.getInstance().deleteAllDeliveriesDB();
            }
        } while (!input.equals("5"));
    }
}
