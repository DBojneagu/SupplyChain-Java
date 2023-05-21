package service;

import model.*;

import java.util.Random;

public class ActionService {

    public Delivery buildDelivery(String name , double price, String vehicle_brand, String vehicle_type) {

        return new Delivery(new Random().nextInt(100000),
                name, price, vehicle_brand, vehicle_type);
    }

    public Assembly buildAssembly( String name, double price, int number_of_products, int number_of_employees ) {

        return new Assembly(new Random().nextInt(100000),
                name, price, number_of_products, number_of_employees);
    }

    public Measuring buildMeasuring( String name, double price, String category) {

        return new Measuring(new Random().nextInt(100000),
                name, price, category);
    }
}
