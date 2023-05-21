package service;

import model.*;

import java.util.Random;

public class OrderService {

    public Order buildOrder(Action a, Product p) {

        return new Order(new Random().nextInt(100000),
                p,a,p.getPrice() +p.getPrice());
    }

}
