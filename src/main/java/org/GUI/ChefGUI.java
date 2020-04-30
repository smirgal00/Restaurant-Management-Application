package org.GUI;

import Business.Restaurant;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class ChefGUI implements Observer {
    private JFrame frame;
    private Restaurant restaurant;
    private JTextField text;
    private JTextArea orders;

    public ChefGUI(Restaurant restaurant) {
        this.restaurant = restaurant;
        frame = new JFrame();
        text = new JTextField();
        orders = new JTextArea();
        orders.setEditable(false);
        frame.setLayout(new GridLayout(2, 1));
        text.setEditable(false);
        frame.setLocationRelativeTo(null);
        frame.add(text);
        frame.add(orders);
        frame.setSize(800, 720);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    @Override
    public void update(Observable o, Object arg) {
        text.setText("A new order has been added!");
        orders.setText("");
        orders.append(restaurant.printOrders());
    }
}
