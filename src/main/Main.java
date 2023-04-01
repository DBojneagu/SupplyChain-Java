package main;

import model.*;
import service.*;

import  java.util.*;
public class Main {
    public static void main (String args[]) {
        Shop shop = new Shop();
        System.out.println(shop.getInstance());
        shop.menu();
    }
}