package model;

public class Product {
    private long id;
    private int price;
    private int stock;
    private String name;

    public Product(long id, int price, int stock, String name) {
        this.id = id;
        this.price = price;
        this.stock = stock;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString () {
        return id + name + stock + price ;
    }
}
