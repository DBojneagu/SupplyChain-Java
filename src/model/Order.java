package model;

public class Order {
    private long id;
    private double price;

    public Order() {}
    public Order(long id ) {
        this.id = id;
    }
    public Order(long id, double price){
        this.id = id;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



}
