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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShopService {
    public void addProduct(Shop shop, Product product) {
        int nextAvailableIndex = getNumberOfProducts(shop);
        shop.getProducts()[nextAvailableIndex] = product;
        String message = "Product " + product.getName() + " was added to the shop";
        System.out.println(message);
    }

    public void addFurniture(Shop shop, Product furniture) {
        int nextAvailableIndex = getNumberOfFurnitures(shop);
        shop.getFurnitures()[nextAvailableIndex] = furniture;

    }

    public void addLighting(Shop shop, Product  lighting) {
        int nextAvailableIndex = getNumberOfLightings(shop);
        shop.getLightings()[nextAvailableIndex] = lighting;

    }

    public void addSmartHome(Shop shop, Product  smartHome) {
        int nextAvailableIndex = getNumberOfSmartHomes(shop);
        shop.getSmartHomes()[nextAvailableIndex] = smartHome;

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
        for (Product  f : shop.getFurnitures()) {
            if (f != null) {
                numberOfFurnitures++;
            }
        }
        return numberOfFurnitures;
    }
    private int getNumberOfSmartHomes(Shop shop) {
        int numberOfSmartHomes = 0;
        for (Product  sm : shop.getSmartHomes()) {
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
        int  i = 0;
        for (Product  f : shop.getFurnitures()) {
            i++;
            if (f != null) {
                System.out.println(i + "->" + f);
            }
        }
    }

    public void printLightingsDetails(Shop shop) {
        int  i = 0;
        for (Product  l : shop.getLightings()) {
            i++;
            if (l != null) {
                System.out.println(i + "->" + l);
            }
        }
    }

    public void printSmartHomesDetails(Shop shop) {
        int  i = 0;
        for (Product  sm : shop.getSmartHomes()) {
            i++;
            if (sm != null) {
                System.out.println(i + "->" + sm);
            }
        }
    }

    public void printProductsDetails(Shop shop) {
        int  i = 0;
        for (Product p : shop.getProducts()) {
            i++;
            if (p != null) {
                System.out.println(i + "->" + p);
            }
        }
    }
}
// nu stiu sigur daca l facem
