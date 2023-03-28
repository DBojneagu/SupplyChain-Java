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
            System.out.println("2. Get the description of  products  ");
            System.out.println("3. Delete a product  ");
            System.out.println("4. Exit ");
            input =(scanner.nextLine());
            if (input.equals("1")){
                System.out.println("Please specify the details for creating a new product: What category do you want it to be?");
                System.out.println("1. Furniture");
                System.out.println("2. Lighting");
                System.out.println("3. SmartHome");
                String productType = scanner.nextLine();
                switch(productType) {
                    case "1" :
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
                           scanner.nextLine();
                          Product added_furniture = productService.buildFurniture(name,price,stock,material,height,width);
                          shopService.addProduct(shop,added_furniture);
                          shopService.addFurniture(shop,added_furniture);
                          break;
                    case "2" :
                        System.out.println("Name:");
                         name = scanner.nextLine();
                        System.out.println("Price:");
                         price = scanner.nextInt();
                        System.out.println("Stock:");
                         stock = scanner.nextInt();
                        System.out.println("power:");
                        int power = scanner.nextInt();
                        System.out.println("type:");
                        scanner.nextLine();
                        String type  = scanner.nextLine();
                        Product added_lighting = productService.buildLighting(name,price,stock,power,type);
                        shopService.addProduct(shop,added_lighting);
                        shopService.addLighting(shop,added_lighting);
                        break;

                    case "3" :
                        System.out.println("Name:");
                         name = scanner.nextLine();
                        System.out.println("Price:");
                         price = scanner.nextInt();
                        System.out.println("Stock:");
                         stock = scanner.nextInt();
                        System.out.println("Category:");
                        scanner.nextLine();
                        String category = scanner.nextLine();
                        System.out.println("appname : ");
                        String appname = scanner.nextLine();
                        Product added_smarthome = productService.buildSmartHome(name,price,stock,category,appname);
                        shopService.addProduct(shop,added_smarthome);
                        shopService.addSmartHome(shop,added_smarthome);
                        break;
                }
            }
            if (input.equals("2")){
                System.out.println("What products do you exactly want to see?");
                System.out.println("1. All products");
                System.out.println("2. Only Furniture Products");
                System.out.println("3. Only Lighting Products");
                System.out.println("4. Only Smarthome Products");
                String input_afis = scanner.nextLine();
                switch(input_afis) {
                    case "1" :
                        shopService.printProductsDetails(shop);
                        break;
                    case "2" :
                        shopService.printFurnituresDetails(shop);
                        break;
                    case "3" :
                        shopService.printLightingsDetails(shop);
                        break;
                    case "4" :
                        shopService.printSmartHomesDetails(shop);
                        break;
                }
            }
            if (input.equals("3")) {
                System.out.println("What product do you exactly want remove?");
                System.out.println("1.  Furniture Product");
                System.out.println("2.  Lighting Product");
                System.out.println("3.  Smarthome Product");
                String input_afis = scanner.nextLine();
                switch(input_afis) {
                    case "1" :
                        Product[] furnitures = shop.getFurnitures();
                        if (furnitures == null) {
                            System.out.println("There are no furniture products to remove.");
                        } else {
                            shopService.printProductsDetails(shop);
                            System.out.println("Specify the id of the product that you want to remove");
                            int id = scanner.nextInt();
                        }
                    case "2" :
                        shopService.printFurnituresDetails(shop);
                        break;
                    case "3" :
                        shopService.printLightingsDetails(shop);
                        break;
                    case "4" :
                        shopService.printSmartHomesDetails(shop);
                        break;
                }

            }

        }while(!input.equals("4"));
    }
}