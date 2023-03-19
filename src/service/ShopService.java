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

public class ShopService {
    public void addProduct(Shop shop, Product product) {
        int nextAvailableIndex = getNumberOfProducts(shop);
        shop.getProducts()[nextAvailableIndex] = product;

        String message = "Product " + product.getName() + " was added to the shop";
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
    public void printProductsDetails(Shop shop) {
        for (Product p : shop.getProducts()) {
            if (p != null) {
                System.out.println(p);
            }
        }
    }
}
// nu stiu sigur daca l facem
