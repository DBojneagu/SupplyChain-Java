package model;

public class Action {

    private long id;
    private String name;
    private double price;

    public Action(long id,String name,double price)
    {
        this.id = id;
        this.name=name;
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

    @Override
    public String toString() {
        return name + " " + price ;
    }

}


