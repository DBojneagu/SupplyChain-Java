package service;
import model.*;

import java.util.*;

public class ProductService {
    //new Furniture(name,price,stock,material,height,width)
    public Furniture buildFurniture(String name,int price, int stock, String material, double height, double width ) {

        return new Furniture(new Random().nextInt(100000),
                name, price, stock, material, height,width);
    }

    public Lighting buildLighting(String name,int price, int stock, int power,String type ) {

        return new Lighting(new Random().nextInt(100000),
                name, price, stock, power, type);
    }

    public SmartHome buildSmartHome(String name,int price, int stock,String category, String appname ) {

        return new SmartHome(new Random().nextInt(100000),
                name, price, stock, category, appname);
    }


}
