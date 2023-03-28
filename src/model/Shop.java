package model;
import java.util.ArrayList;
import java.util.List;
public class Shop {
    private Product[] products = new Product[100];
    private Product[] furnitures = new Product[100];
    private Product[] lightings = new Product[100];
    private Product[] SmartHomes = new Product[100];

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }


    public Product[] getFurnitures() {
        return furnitures;
    }
    public void removeObjects(List<Product> products, int idToRemove) {
        products.removeIf(obj -> obj.getId() == idToRemove);
    }

    public void setFurnitures(Product[] furnitures) {
        this.furnitures = furnitures;
    }

    public Product[] getLightings() {
        return lightings;
    }

    public void setLightings(Product[] lightings) {
        this.lightings = lightings;
    }

    public Product[] getSmartHomes() {
        return SmartHomes;
    }

    public void setSmartHomes(Product[] smartHomes) {
        SmartHomes = smartHomes;
    }
}
// Nu stiu sigur daca facem si shop
