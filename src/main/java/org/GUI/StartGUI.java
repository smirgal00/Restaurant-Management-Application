package org.GUI;
import Business.Restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGUI {
    private JFrame frame;
    private JButton waiter;
    private JButton admin;
    private JButton chef;
    private Restaurant restaurant;

    public StartGUI(Restaurant restaurant) {
        this.restaurant = restaurant;
        frame = new JFrame();
        waiter = new JButton("Waiter");
        admin = new JButton("Admin");
        chef = new JButton("Chef");

        frame.setLayout(new GridLayout(3, 1));
        frame.add(waiter);
        frame.add(admin);
        frame.add(chef);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 720);
        frame.setResizable(false);
        frame.setVisible(true);

        buttonListeners();
    }

    private void buttonListeners() {
        waiter.addActionListener(e -> {
            WaiterGUI waiterGUI = new WaiterGUI(restaurant);
        });

        admin.addActionListener(e -> {
            AdministratorGUI administratorGUI = new AdministratorGUI(restaurant);
        });

        chef.addActionListener(e -> {
            ChefGUI chefGUI = new ChefGUI();
        });
    }
}
