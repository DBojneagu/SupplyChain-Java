package model;
import service.ProductService;
import service.ShopService;
import service.*;
import model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {
    String input;
    String menutype ;
    ShopService shopService = new ShopService();
    ProductService productService = new ProductService();

    ActionService actionService = new ActionService();
    Scanner scanner = new Scanner(System.in);
    private List<Product> products = new ArrayList<>();
    private List<Furniture> furnitures = new ArrayList<>();
    private List<Lighting> lightings = new ArrayList<>();
    private List<SmartHome> smartHomes = new ArrayList<>();
    private List<Action> actions = new ArrayList<>();
    private List<Delivery> deliveries = new ArrayList<>();
    private List<Measuring> measurings = new ArrayList<>();
    private List<Assembly> assemblies = new ArrayList<>();
    private static Shop single_instance = null;

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public List<Measuring> getMeasurings() {
        return measurings;
    }

    public void setMeasurings(List<Measuring> measurings) {
        this.measurings = measurings;
    }

    public List<Assembly> getAssemblies() {
        return assemblies;
    }

    public void setAssemblies(List<Assembly> assemblies) {
        this.assemblies = assemblies;
    }

    public static synchronized Shop getInstance(){
        if(single_instance == null){
            single_instance = new Shop();
        }
        return single_instance;
    }
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Furniture> getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(List<Furniture> furnitures) {
        this.furnitures = furnitures;
    }

    public List<Lighting> getLightings() {
        return lightings;
    }

    public void setLightings(List<Lighting> lightings) {
        this.lightings = lightings;
    }

    public List<SmartHome> getSmartHomes() {
        return smartHomes;
    }

    public void setSmartHomes(List<SmartHome> smartHomes) {
        this.smartHomes = smartHomes;
    }

    public void init() {
        Furniture added_furniture = productService.buildFurniture("Scaun",200,100,"bumbac",10,10);
        System.out.println(getInstance());
        shopService.addProduct(getInstance(),added_furniture);
        shopService.addFurniture(getInstance(),added_furniture);
        Furniture added_furniture2 = productService.buildFurniture("Canapea",200,100,"Piele Naturala",200,100);
        System.out.println(getInstance());
        shopService.addProduct(getInstance(),added_furniture2);
        shopService.addFurniture(getInstance(),added_furniture2);
        Furniture added_furniture3 = productService.buildFurniture("Birou",200,100,"Stejar",200,160);
        System.out.println(getInstance());
        shopService.addProduct(getInstance(),added_furniture3);
        shopService.addFurniture(getInstance(),added_furniture3);
        Furniture added_furniture4 = productService.buildFurniture("Noptiera",200,100,"Brad",300,450);
        System.out.println(getInstance());
        shopService.addProduct(getInstance(),added_furniture4);
        shopService.addFurniture(getInstance(),added_furniture4);
    }
    public void menu() {
            do
            {
                System.out.println("Ikea Menu");
                System.out.println("1. Products");
                System.out.println("2. Actions ");
                System.out.println("3. Exit  ");
                menutype =(scanner.nextLine());
                if (menutype.equals("1")) {
                    System.out.println("Ikea Menu");
                    System.out.println("1. Add a new Product Information");
                    System.out.println("2. Get the description of  products  ");
                    System.out.println("3. Delete a product  ");
                    System.out.println("4. Search products by price range ");
                    System.out.println("5. Sort the products by price ");
                    System.out.println("6. Go back to main menu ");
                    input = (scanner.nextLine());
                    do {
                        if (input.equals("1")) {
                            System.out.println("Please specify the details for creating a new product: What category do you want it to be?");
                            System.out.println("1. Furniture");
                            System.out.println("2. Lighting");
                            System.out.println("3. SmartHome");
                            String productType = scanner.nextLine();
                            switch (productType) {
                                case "1":
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
                                    Furniture added_furniture = productService.buildFurniture(name, price, stock, material, height, width);
                                    shopService.addProduct(getInstance(), added_furniture);
                                    shopService.addFurniture(getInstance(), added_furniture);
                                    break;
                                case "2":
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
                                    String type = scanner.nextLine();
                                    Lighting added_lighting = productService.buildLighting(name, price, stock, power, type);
                                    shopService.addProduct(getInstance(), added_lighting);
                                    shopService.addLighting(getInstance(), added_lighting);
                                    break;

                                case "3":
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
                                    SmartHome added_smarthome = productService.buildSmartHome(name, price, stock, category, appname);
                                    shopService.addProduct(getInstance(), added_smarthome);
                                    shopService.addSmartHome(getInstance(), added_smarthome);
                                    break;
                            }
                        }
                        if (input.equals("2")) {
                            System.out.println("What products do you exactly want to see?");
                            System.out.println("1. All products");
                            System.out.println("2. Only Furniture Products");
                            System.out.println("3. Only Lighting Products");
                            System.out.println("4. Only Smarthome Products");
                            String input_afis = scanner.nextLine();
                            switch (input_afis) {
                                case "1":
                                    shopService.printProductsDetails(getInstance());
                                    break;
                                case "2":
                                    shopService.printFurnituresDetails(getInstance());
                                    break;
                                case "3":
                                    shopService.printLightingsDetails(getInstance());
                                    break;
                                case "4":
                                    shopService.printSmartHomesDetails(getInstance());
                                    break;
                            }
                        }
                        if (input.equals("3")) {
                            System.out.print("Enter the ID of the furniture you want to remove: ");
                            long furnitureId = scanner.nextLong();
                            scanner.nextLine(); // consume the newline character
                            shopService.removeFurniture(getInstance(), furnitureId);
                            shopService.removeProduct(getInstance(), furnitureId);
                        }
                        if (input.equals("4")) { // show products by price range
                            System.out.print("Enter minumum: ");
                            int lower = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Enter maximum: ");
                            int higher = scanner.nextInt();
                            scanner.nextLine();

                            shopService.printProductsDetailsByRange(getInstance(), lower, higher);

                        }

                        if (input.equals("5")) {
                            shopService.printProductsDetailsSorted(getInstance());
                        }
                    } while (!input.equals("6"));
                }

                else if (menutype.equals("2")) {
                    // delivery menu
                    if (menutype.equals("1")) {
                        System.out.println("Ikea Menu");
                        System.out.println("1. Add a new Product Information");
                        System.out.println("2. Get the description of  products  ");
                        System.out.println("3. Delete a product  ");
                        System.out.println("4. Search products by price range ");
                        System.out.println("5. Sort the products by price ");
                        System.out.println("6. Go back to main menu ");
                        input = (scanner.nextLine());
                        do {
                            if (input.equals("1")) {
                                System.out.println("Please specify the details for creating a new product: What category do you want it to be?");
                                System.out.println("1. Furniture");
                                System.out.println("2. Lighting");
                                System.out.println("3. SmartHome");
                                String productType = scanner.nextLine();
                                switch (productType) {
                                    case "1":
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
                                        Furniture added_furniture = productService.buildFurniture(name, price, stock, material, height, width);
                                        shopService.addProduct(getInstance(), added_furniture);
                                        shopService.addFurniture(getInstance(), added_furniture);
                                        break;
                                    case "2":
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
                                        String type = scanner.nextLine();
                                        Lighting added_lighting = productService.buildLighting(name, price, stock, power, type);
                                        shopService.addProduct(getInstance(), added_lighting);
                                        shopService.addLighting(getInstance(), added_lighting);
                                        break;

                                    case "3":
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
                                        SmartHome added_smarthome = productService.buildSmartHome(name, price, stock, category, appname);
                                        shopService.addProduct(getInstance(), added_smarthome);
                                        shopService.addSmartHome(getInstance(), added_smarthome);
                                        break;
                                }
                            }
                            if (input.equals("2")) {
                                System.out.println("What products do you exactly want to see?");
                                System.out.println("1. All products");
                                System.out.println("2. Only Furniture Products");
                                System.out.println("3. Only Lighting Products");
                                System.out.println("4. Only Smarthome Products");
                                String input_afis = scanner.nextLine();
                                switch (input_afis) {
                                    case "1":
                                        shopService.printProductsDetails(getInstance());
                                        break;
                                    case "2":
                                        shopService.printFurnituresDetails(getInstance());
                                        break;
                                    case "3":
                                        shopService.printLightingsDetails(getInstance());
                                        break;
                                    case "4":
                                        shopService.printSmartHomesDetails(getInstance());
                                        break;
                                }
                            }
                            if (input.equals("3")) {
                                System.out.print("Enter the ID of the furniture you want to remove: ");
                                long furnitureId = scanner.nextLong();
                                scanner.nextLine(); // consume the newline character
                                shopService.removeFurniture(getInstance(), furnitureId);
                                shopService.removeProduct(getInstance(), furnitureId);
                            }
                            if (input.equals("4")) { // show products by price range
                                System.out.print("Enter minumum: ");
                                int lower = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Enter maximum: ");
                                int higher = scanner.nextInt();
                                scanner.nextLine();

                                shopService.printProductsDetailsByRange(getInstance(), lower, higher);

                            }

                            if (input.equals("5")) {
                                shopService.printProductsDetailsSorted(getInstance());
                            }
                        }while (!input.equals("6")) ;
                        }
                            else if (menutype.equals("2")) {

                            }

                }
            }while(!menutype.equals("3"));

        }

}

// Nu stiu sigur daca facem si shop
