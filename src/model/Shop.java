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
    String menutype;

    String input2;
    ShopService shopService = new ShopService();
    ProductService productService = new ProductService();
    OrderService orderService = new OrderService();
    ActionService actionService = new ActionService();
    Scanner scanner = new Scanner(System.in);
    private List < Product > products = new ArrayList < > ();
    private List < Furniture > furnitures = new ArrayList < > ();
    private List < Lighting > lightings = new ArrayList < > ();
    private List < SmartHome > smartHomes = new ArrayList < > ();
    private List < Action > actions = new ArrayList < > ();
    private List < Order > orders = new ArrayList < > ();
    private List < Delivery > deliveries = new ArrayList < > ();
    private List < Measuring > measurings = new ArrayList < > ();
    private List < Assembly > assemblies = new ArrayList < > ();
    private static Shop single_instance = null;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List < Action > getActions() {
        return actions;
    }

    public void setActions(List < Action > actions) {
        this.actions = actions;
    }

    public List < Delivery > getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List < Delivery > deliveries) {
        this.deliveries = deliveries;
    }

    public List < Measuring > getMeasurings() {
        return measurings;
    }

    public void setMeasurings(List < Measuring > measurings) {
        this.measurings = measurings;
    }

    public List < Assembly > getAssemblies() {
        return assemblies;
    }

    public void setAssemblies(List < Assembly > assemblies) {
        this.assemblies = assemblies;
    }

    public static synchronized Shop getInstance() {
        if (single_instance == null) {
            single_instance = new Shop();
        }
        return single_instance;
    }
    public List < Product > getProducts() {
        return products;
    }

    public void setProducts(List < Product > products) {
        this.products = products;
    }

    public List < Furniture > getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(List < Furniture > furnitures) {
        this.furnitures = furnitures;
    }

    public List < Lighting > getLightings() {
        return lightings;
    }

    public void setLightings(List < Lighting > lightings) {
        this.lightings = lightings;
    }

    public List < SmartHome > getSmartHomes() {
        return smartHomes;
    }

    public void setSmartHomes(List < SmartHome > smartHomes) {
        this.smartHomes = smartHomes;
    }

    public void init() {
        Furniture added_furniture = productService.buildFurniture("Scaun", 200, 100, "bumbac", 10, 10);
        shopService.addProduct(getInstance(), added_furniture);
        shopService.addFurniture(getInstance(), added_furniture);

        Furniture added_furniture2 = productService.buildFurniture("Canapea", 500, 60, "Piele Naturala", 200, 100);
        shopService.addProduct(getInstance(), added_furniture2);
        shopService.addFurniture(getInstance(), added_furniture2);

        Furniture added_furniture3 = productService.buildFurniture("Birou", 700, 250, "Stejar", 200, 160);
        shopService.addProduct(getInstance(), added_furniture3);
        shopService.addFurniture(getInstance(), added_furniture3);

        Furniture added_furniture4 = productService.buildFurniture("Noptiera", 50, 10, "Brad", 300, 450);
        shopService.addProduct(getInstance(), added_furniture4);
        shopService.addFurniture(getInstance(), added_furniture4);

        Lighting added_lighting1 = productService.buildLighting("Bec", 200, 100, 300,"electric");
        shopService.addProduct(getInstance(), added_lighting1);
        shopService.addLighting(getInstance(), added_lighting1);

        Lighting added_lighting2 = productService.buildLighting("Lanterna", 500, 20, 30,"electric");
        shopService.addProduct(getInstance(), added_lighting2);
        shopService.addLighting(getInstance(), added_lighting2);

        SmartHome added_smarthome1 = productService.buildSmartHome("Dumbell", 200, 100, "LifeStyle","Stepper");
        shopService.addProduct(getInstance(), added_smarthome1);
        shopService.addSmartHome(getInstance(), added_smarthome1);

        SmartHome added_smarthome2 = productService.buildSmartHome("Treadmill", 1000, 100, "Fitness","Now");
        shopService.addProduct(getInstance(), added_smarthome2);
        shopService.addSmartHome(getInstance(), added_smarthome2);


        Delivery added_delivery1 = actionService.buildDelivery("UPS", 200, "Mazda", "SUV");
        shopService.addAction(getInstance(), added_delivery1);
        shopService.addDelivery(getInstance(), added_delivery1);

        Delivery added_delivery2 = actionService.buildDelivery("DHL", 500, "Ford", "Sedan");
        shopService.addAction(getInstance(), added_delivery2);
        shopService.addDelivery(getInstance(), added_delivery2);

        Delivery added_delivery3 = actionService.buildDelivery("SameDay", 1000, "Dacia", "Van");
        shopService.addAction(getInstance(), added_delivery3);
        shopService.addDelivery(getInstance(), added_delivery3);

        Delivery added_delivery4 = actionService.buildDelivery("Fan", 1000, "Renault", "Van");
        shopService.addAction(getInstance(), added_delivery4);
        shopService.addDelivery(getInstance(), added_delivery4);

        Measuring added_measuring1 = actionService.buildMeasuring("Ikea_Measuring", 2000, "Outside");
        shopService.addAction(getInstance(), added_measuring1);
        shopService.addMeasuring(getInstance(), added_measuring1);

        Measuring added_measuring2 = actionService.buildMeasuring("Ikea_Measuring", 1000, "Inside");
        shopService.addAction(getInstance(), added_measuring2);
        shopService.addMeasuring(getInstance(), added_measuring2);

        Assembly added_assembly1 = actionService.buildAssembly("Jenga", 10000, 10, 20);
        shopService.addAction(getInstance(), added_assembly1);
        shopService.addAssembly(getInstance(), added_assembly1);

        Assembly added_assembly2 = actionService.buildAssembly("Ikea_Assemblers", 20000, 12, 15);
        shopService.addAction(getInstance(), added_assembly2);
        shopService.addAssembly(getInstance(), added_assembly2);

        Order added_order = orderService.buildOrder(added_assembly1,added_furniture3);
        shopService.addOrder(getInstance(),added_order);

        Order added_order2 = orderService.buildOrder(added_assembly2,added_smarthome1);
        shopService.addOrder(getInstance(),added_order2);

        Order added_order3 = orderService.buildOrder(added_delivery1,added_lighting2);
        shopService.addOrder(getInstance(),added_order3);

        Order added_order4 = orderService.buildOrder(added_measuring1,added_furniture4);
        shopService.addOrder(getInstance(),added_order4);
    }
    public void menu_productsAndActions() {
        do {
            System.out.println("Ikea Menu");
            System.out.println("1. Products");
            System.out.println("2. Actions ");
            System.out.println("3. Exit  ");
            menutype = scanner.nextLine();


            if (menutype.equals("1")) {

                do {
                    System.out.println("Ikea Menu");
                    System.out.println("1. Add a new Product Information" + "                                       "+"Total number of Products " + shopService.getNumberOfProducts(getInstance()) );
                    System.out.println("2. Get the description of  products  " + "                                  "+"Number of Furnitures : " + shopService.getNumberOfFurnitures(getInstance()) );
                    System.out.println("3. Delete a product  " + "                                                  "+"Number of Lightings : "+ shopService.getNumberOfLightings(getInstance()));
                    System.out.println("4. Search products by price range " + "                                     "+ "Number of SmartHomes : " + shopService.getNumberOfSmartHomes(getInstance()));
                    System.out.println("5. Sort the products by price ");
                    System.out.println("6. Go back to main menu ");
                    input = (scanner.nextLine());
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
                        System.out.println("What type of Product do you want to remove? ");
                        System.out.println("1. Furniture ");
                        System.out.println("2. Lighting");
                        System.out.println("3. SmartHome ");
                        String product_type = scanner.nextLine();
                        switch (product_type) {
                            case "1" :
                                shopService.printFurnituresDetails(getInstance());
                                System.out.print("Enter the ID of the furniture you want to remove: ");
                                long furnitureId = scanner.nextLong();
                                scanner.nextLine(); // consume the newline character
                                shopService.removeFurniture(getInstance(), furnitureId);
                                shopService.removeProduct(getInstance(), furnitureId);
                                break;
                            case "2":
                                shopService.printLightingsDetails(getInstance());
                                System.out.print("Enter the ID of the Lighting you want to remove: ");
                                long lightingId = scanner.nextLong();
                                scanner.nextLine(); // consume the newline character
                                shopService.removeLighting(getInstance(), lightingId);
                                shopService.removeProduct(getInstance(), lightingId);
                                break;
                            case "3" :
                                shopService.printSmartHomesDetails(getInstance());
                                System.out.print("Enter the ID of the SmartHome you want to remove: ");
                                long smarthomeId = scanner.nextLong();
                                scanner.nextLine(); // consume the newline character
                                shopService.removeSmartHome(getInstance(), smarthomeId);
                                shopService.removeProduct(getInstance(), smarthomeId);
                                break;
                        }
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

            } else if (menutype.equals("2")) {

                do {
                    System.out.println("Ikea Menu");
                    System.out.println("1. Add a new Action" + "                                                "+ "Total number of Actions " + shopService.getNumberOfActions(getInstance()));
                    System.out.println("2. Get all the actions available " + "                                  "+ "Number of Deliveries : " + shopService.getNumberOfDeliveries(getInstance()));
                    System.out.println("3. Delete an existing action " + "                                      "+ "Number of Measurings : "+ shopService.getNumberOfMeasurings(getInstance()));
                    System.out.println("4. Go back to main menu " + "                                           "+ "Number of Assemblies : " + shopService.getNumberOfAssembly(getInstance()));
                    input2 = scanner.nextLine();
                    if (input2.equals("1")) {
                        System.out.println("Please specify the details for creating a new action: What category do you want it to be?");
                        System.out.println("1. Delivery");
                        System.out.println("2. Measuring");
                        System.out.println("3. Assembly");
                        String actionType = scanner.nextLine();
                        switch (actionType) {
                            case "1":
                                System.out.println("Name:");
                                String name = scanner.nextLine();
                                System.out.println("Price:");
                                int price = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Vehicle Brand");
                                String vehicle_brand = scanner.nextLine();
                                System.out.println("Vehicle Type:");
                                String vehicle_type = scanner.nextLine();
                                scanner.nextLine();

                                Delivery added_delivery = actionService.buildDelivery(name, price, vehicle_brand, vehicle_type);
                                shopService.addDelivery(getInstance(), added_delivery);
                                shopService.addAction(getInstance(), added_delivery);
                                break;
                            case "2":
                                System.out.println("Name:");
                                name = scanner.nextLine();
                                System.out.println("Price:");
                                price = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Category:");
                                String category = scanner.nextLine();

                                Measuring added_measuring = actionService.buildMeasuring(name, price, category);
                                shopService.addAction(getInstance(), added_measuring);
                                shopService.addMeasuring(getInstance(), added_measuring);
                                break;

                            case "3":
                                System.out.println("Name:");
                                name = scanner.nextLine();
                                System.out.println("Price:");
                                price = scanner.nextInt();
                                System.out.println("Number of products to be assembled");
                                int number_of_products = scanner.nextInt();
                                System.out.println("Number of employees needed");
                                int number_of_employees = scanner.nextInt();
                                scanner.nextLine();
                                Assembly added_assembly = actionService.buildAssembly(name, price, number_of_products, number_of_employees);
                                shopService.addAction(getInstance(), added_assembly);
                                shopService.addAssembly(getInstance(), added_assembly);
                                break;
                        }
                    }
                    else if (input2.equals("2")) {
                        System.out.println("What Actions do you exactly want to see?");
                        System.out.println("1. All Actions");
                        System.out.println("2. Only Delivery Actions");
                        System.out.println("3. Only Measuring Actions");
                        System.out.println("4. Only Assembly Actions");
                        String input_afis = scanner.nextLine();
                        switch (input_afis) {
                            case "1":
                                shopService.printActionsDetails(getInstance());
                                break;
                            case "2":
                                shopService.printDeliveryDetails(getInstance());
                                break;
                            case "3":
                                shopService.printMeasuringDetails(getInstance());
                                break;
                            case "4":
                                shopService.printAssemblyDetails(getInstance());
                                break;
                        }

                    }
                    else if (input2.equals("3")) {

                        System.out.println("What type of action do you want to remove? ");
                        System.out.println("1. Delivery ");
                        System.out.println("2. Measuring");
                        System.out.println("3. Assembly ");
                        String action_type = scanner.nextLine();
                        switch (action_type) {
                            case "1" :
                                shopService.printDeliveryDetails(getInstance());
                                System.out.print("Enter the ID of the delivery you want to remove: ");
                                long deliveryId = scanner.nextLong();
                                scanner.nextLine(); // consume the newline character
                                shopService.removeDelivery(getInstance(), deliveryId);
                                shopService.removeAction(getInstance(), deliveryId);
                                break;
                            case "2":
                                shopService.printMeasuringDetails(getInstance());
                                System.out.print("Enter the ID of the measuring you want to remove: ");
                                long measuringId = scanner.nextLong();
                                scanner.nextLine(); // consume the newline character
                                shopService.removeMeasuring(getInstance(), measuringId);
                                shopService.removeAction(getInstance(), measuringId);
                                break;
                            case "3" :
                                shopService.printAssemblyDetails(getInstance());
                                System.out.print("Enter the ID of the assembly you want to remove: ");
                                long assemblyId = scanner.nextLong();
                                scanner.nextLine(); // consume the newline character
                                shopService.removeAssembly(getInstance(), assemblyId);
                                shopService.removeAction(getInstance(), assemblyId);
                                break;
                        }
                    }
                } while (!input2.equals("4"));
            }
        } while (!menutype.equals("3"));

    }
    public void menu_orders() {
            String input_orders;
            do {
                System.out.println("Ikea Menu");
                System.out.println("1. Add a new Order "+  "                                                "+ "Total number of Orders " + shopService.getNumberOfOrders(getInstance()));
                System.out.println("2. See all orders ");
                System.out.println("3. Delete an order ");
                System.out.println("4. Go back to main menu ");
                input_orders = (scanner.nextLine());
                if (input_orders.equals("1")) {
                    System.out.println("Please select a product, and the action wanted: ");
                    shopService.printActionsDetails(getInstance());
                    shopService.printProductsDetails(getInstance());
                    System.out.println("The id of the product");
                    int product_id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("The id of the action");
                    int action_id = scanner.nextInt();
                    scanner.nextLine();

                    Order added_order = orderService.buildOrder(shopService.getActionById(getInstance(),action_id),shopService.getProductById(getInstance(),product_id));
                    shopService.addOrder(getInstance(),added_order);

                }

                else if (input_orders.equals("2")) {
                    shopService.printOrdersDetails(getInstance());
                }
                else if (input_orders.equals("3")) {
                    shopService.printOrdersDetails(getInstance());
                    System.out.print("Enter the ID of the order you want to remove: ");
                    long orderId = scanner.nextLong();
                    scanner.nextLine(); // consume the newline character
                    shopService.removeOrders(getInstance(), orderId);
                }
            } while (!input_orders.equals("4"));
    }

}

// Nu stiu sigur daca facem si shop