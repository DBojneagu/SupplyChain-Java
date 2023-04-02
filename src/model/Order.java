package model;

public class Order {
    private long id;
    private Product product;
    private Action action;
    private double price;

    public Order(long id,Product product, Action action, double price) {
        this.product = product;
        this.action = action;
        this.id = id;
        this.price = product.getPrice() + action.getPrice();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
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
    @Override
    public String toString () {
        return " Id: "+ id +  " |  Action: " + action + " \n            | Product  :  "  + product  + " | Price: "  + price + "\n"  ;
    }
}
