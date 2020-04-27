package org.GUI;

import Business.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class for executing the application
 */

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Restaurant!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant();
        MenuItem item1 = new BaseProduct("apa", 15.0);
        MenuItem item2 = new BaseProduct("pui", 10.0);
        MenuItem item3 = new BaseProduct("pula", 1.0);
        MenuItem item4 = new BaseProduct("apa", 10.0);

        List<MenuItem> menuItemList = new ArrayList<>();
        menuItemList.add(item1);
        menuItemList.add(item2);

        restaurant.createItem(menuItemList, "Ciorba de pui");
        restaurant.createItem(menuItemList, "Ciorba");

        //restaurant.printMenuItems();

        menuItemList.add(item3);

        restaurant.editMenuItem(item1, item4);

        restaurant.printMenuItems();

        launch();
    }

}