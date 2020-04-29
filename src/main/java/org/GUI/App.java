package org.GUI;

import Business.*;
import Data.Serializer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * Main class for executing the application
 */

public class App {

    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant();
        Serializer ser = new Serializer("restaurant");

       /* MenuItem item1 = new BaseProduct("caine", 13.0);
        MenuItem item2 = new BaseProduct("sad", 1.2);

        MenuItem item3 = new BaseProduct("caine", 13.0);
        MenuItem item4 = new BaseProduct("sad", 1.2);

        List<MenuItem> menu = new ArrayList<>();
        menu.add(item1);
        menu.add(item2);

        restaurant.createItem(menu, "Pula");
        menu.remove(item1);
        menu.remove(item2);
        menu.add(item3);
        menu.add(item4);
        restaurant.createItem(menu, "Rusu");*/

        restaurant = ser.deserializeInfo();
        restaurant.printMenuItems();

        StartGUI startGUI = new StartGUI(restaurant);


    }

}