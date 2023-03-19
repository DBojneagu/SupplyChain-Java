package model;

public class Product {
    private long id;
    private String name;
    private int price;
    private int stock;


    public Product(long id,String name, int price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;

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
        return " Id: "+ id +  " |  Name: " + name + " | Stock:  "  + stock + " | Price: "  + price  ;
    }
}
