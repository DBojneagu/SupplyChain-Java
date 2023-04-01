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
            if (input.equals("1")) {
                shop.menu();
            }
//            else if (input.equals("2")) {
//                orders.menu();
//            }
        } while (!input.equals("3"));
    }
}