package model;

public  class Furniture extends Product {
    private String material;
    private double height;
    private double width;

    public Furniture(long id, String name,int price, int stock,  String material, double height, double width) {
        super(id, name ,stock, price);
        this.material = material;
        this.height = height;
        this.width = width;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    @Override
    public String toString() {
        return super.toString() + " | Width: " + width + " | Height: " + height ;
    }
}
