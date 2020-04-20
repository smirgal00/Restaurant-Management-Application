package org.GUI;

import Business.BaseProduct;
import Business.CompositeProduct;
import Business.MenuItem;
import Business.Restaurant;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

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

        CompositeProduct compositeProduct = new CompositeProduct("Ciorba");
        compositeProduct.addItem(new BaseProduct("carne", 5.0));
        compositeProduct.addItem(new BaseProduct("apa", 1.0));

        restaurant.addMenuItem(compositeProduct);
        restaurant.addMenuItem(compositeProduct);

        restaurant.printMenu();

        launch();
    }

}