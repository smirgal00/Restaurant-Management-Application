package org.GUI;

import Business.*;
import Data.Serializer;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class for executing the application
 */

public class App {

    public static void main(String[] args) {

        Restaurant restaurant = null;
        Serializer ser = new Serializer(args[0]);

        restaurant = ser.deserializeInfo();
        StartGUI startGUI = new StartGUI(restaurant, args[0]);
        ChefGUI chefGUI = new ChefGUI(restaurant);
        restaurant.addObserver(chefGUI);


    }

}