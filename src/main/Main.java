package main;

import model.*;
import service.*;

import  java.util.*;
public class Main {
    public static void main (String args[])
    {
        String input;
        Shop shop = new Shop();
        ShopService shopService = new ShopService();
        ProductService productService = new ProductService();

        Scanner scanner = new Scanner(System.in);
        do
        {
            System.out.println("Ikea Menu");
            System.out.println("1. Add a new Product Information");
            System.out.println("2. Get the description of all products  ");
            System.out.println("3. Exit ");
            input =(scanner.nextLine());
            if (input.equals("1")){
                System.out.println("Please specify the details for creating a new product: What category do you want it to be?");
                System.out.println("1. Furniture");
                System.out.println("2. Lighting");
                System.out.println("3. SmartHome");
                String productType = scanner.nextLine();
                switch(productType) {
                    case "1" : {
                        System.out.println("Name:");
                          String name = scanner.nextLine();
                        System.out.println("Price:");
                          int price = scanner.nextInt();
                        System.out.println("Stock:");
                          int stock = scanner.nextInt();
                        System.out.println("Material:");
                          scanner.nextLine();
                          String material = scanner.nextLine();
                        System.out.println("height:");
                          double height = scanner.nextDouble();
                        System.out.println("Width:");
                          double width = scanner.nextDouble();
                          shopService.addProduct(shop,productService.buildFurniture(name,price,stock,material,height,width));
                    }
                }
            }
            if (input.equals("2")){
                shopService.printProductsDetails(shop);
            }

        }while(!input.equals("3"));
    }
}