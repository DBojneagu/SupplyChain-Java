package service;

import model.Product;
import model.SmartHome;
import model.Furniture;
import model.Lighting;
import model.Service;
import model.Delivery;
import model.Assembly;
import model.Measuring;
import model.Shop;

import java.util.*;

public class ShopService {

    ProductService productService = new ProductService();



    public void addProduct(Shop shop, Product product) {
        shop.getProducts().add(product);
        String message = "Product " + product.getName() + " was added to the shop";
        System.out.println(message);
    }

    public void removeProduct(Shop shop, long id) {
        shop.getProducts().removeIf(obj -> obj.getId() == id);
        System.out.println("Produsul a fost sters");
    }

    public void addFurniture(Shop shop, Furniture furniture) {

        shop.getFurnitures().add(furniture);

    }

    public void removeFurniture(Shop shop, long id) {
        shop.getFurnitures().removeIf(obj -> obj.getId() == id);
        System.out.println("Furniture a fost sters");
    }

    public void addLighting(Shop shop, Lighting lighting) {
        shop.getProducts().add(lighting);

    }

    public void addSmartHome(Shop shop, SmartHome smartHome) {
        shop.getProducts().add(smartHome);

    }

    private int getNumberOfProducts(Shop shop) {
        int numberOfProducts = 0;
        for (Product p : shop.getProducts()) {
            if (p != null) {
                numberOfProducts++;
            }
        }
        return numberOfProducts;
    }

    private int getNumberOfFurnitures(Shop shop) {
        int numberOfFurnitures = 0;
        for (Product f : shop.getFurnitures()) {
            if (f != null) {
                numberOfFurnitures++;
            }
        }
        return numberOfFurnitures;
    }

    private int getNumberOfSmartHomes(Shop shop) {
        int numberOfSmartHomes = 0;
        for (Product sm : shop.getSmartHomes()) {
            if (sm != null) {
                numberOfSmartHomes++;
            }
        }
        return numberOfSmartHomes;
    }

    private int getNumberOfLightings(Shop shop) {
        int numberOfLightings = 0;
        for (Product l : shop.getLightings()) {
            if (l != null) {
                numberOfLightings++;
            }
        }
        return numberOfLightings;
    }

    public void printFurnituresDetails(Shop shop) {
        int i = 0;
        for (Product f : shop.getFurnitures()) {
            i++;
            if (f != null) {
                System.out.println(i + "->" + f);
            }
        }
    }

    public void printLightingsDetails(Shop shop) {
        int i = 0;
        for (Product l : shop.getLightings()) {
            i++;
            if (l != null) {
                System.out.println(i + "->" + l);
            }
        }
    }

    public void printSmartHomesDetails(Shop shop) {
        int i = 0;
        for (Product sm : shop.getSmartHomes()) {
            i++;
            if (sm != null) {
                System.out.println(i + "->" + sm);
            }
        }
    }

    public void printProductsDetails(Shop shop) {
        int i = 0;
        for (Product p : shop.getProducts()) {
            i++;
            if (p != null) {
                System.out.println(i + "->" + p);
            }
        }

    }

    public void printProductsDetailsByRange(Shop shop, int lower, int higher) {
        int i = 0;
        for (Product p : shop.getProducts()) {
            i++;
            if (p != null && p.getPrice() >= lower && p.getPrice() <= higher) {
                System.out.println(i + "->" + p);
            }
        }
    }

    public void printProductsDetailsSorted(Shop shop) {
         List<Product> sorted_products = shop.getProducts();
        Collections.sort(sorted_products);
        int i = 0;
        for (Product p : sorted_products) {
            i++;
            if (p != null ) {
                System.out.println(i + "->" + p);
            }
        }
    }
    public void init(Shop shop) {
        addFurniture(shop,productService.buildFurniture("Scaun",100,200,"matase",200,300));
        System.out.println(shop);
        printFurnituresDetails(shop);
    }


}
// nu stiu sigur daca l facem
