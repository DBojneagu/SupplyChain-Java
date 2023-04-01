package model;

public  class Delivery extends Action {
    private String vehicle_brand;
    private String vehicle_type;

    public Delivery(long id,String name , double price, String vehicle_brand, String vehicle_type) {
        super(id, name, price);
        this.vehicle_brand = vehicle_brand;
        this.vehicle_type = vehicle_type;
    }

    public String getVehicle_brand() {
        return vehicle_brand;
    }

    public void setVehicle_brand(String vehicle_brand) {
        this.vehicle_brand = vehicle_brand;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }
}
