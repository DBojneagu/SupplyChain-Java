package model;
import java.util.ArrayList;
import java.util.List;
public class Shop {
    private List<Product> products = new ArrayList<>();
    private List<Furniture> furnitures = new ArrayList<>();
    private List<Lighting> lightings = new ArrayList<>();
    private List<SmartHome> smartHomes = new ArrayList<>();

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
}
// Nu stiu sigur daca facem si shop
