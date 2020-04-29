package Data;

import Business.MenuItem;
import Business.Order;
import Business.Restaurant;

import java.io.*;
import java.util.List;
import java.util.Map;

public class Serializer {
    private final String fileName;

    public Serializer(String fileName) {
        this.fileName = fileName;
    }

    public void serializeInfo(Restaurant restaurant) {
        try {
            FileOutputStream fis = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fis);
            oos.writeObject(restaurant);
            oos.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Restaurant deserializeInfo() {
        Restaurant restaurant = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            restaurant = (Restaurant) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return restaurant;
    }

}
