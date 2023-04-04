package main;

import model.*;
import service.*;

import  java.util.*;
public class Main {
    public static void main(String args[]) {
        Shop shop = new Shop();
        shop.init();
        String input;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Ikea Menu");
            System.out.println("1. Products Menu & Delivery Menu");
            System.out.println("2. Orders Menu");
            System.out.println("3. Exit ");
            input = scanner.nextLine();
            while (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
                System.out.println("Invalid input. Please enter a valid option: ");
                input= scanner.nextLine();
            }
            if (input.equals("1")) {
                shop.menu_productsAndActions();
            }
        else if (input.equals("2")) {
                shop.menu_orders();
            }
        } while (!input.equals("3"));
    }
}