package org.GUI;

import Business.Restaurant;
import Business.MenuItem;
import org.jdesktop.swingx.painter.effects.InnerGlowPathEffect;

import javax.swing.*;
import java.awt.*;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class WaiterGUI {
    private JFrame frame;
    private Restaurant restaurant;
    private JButton add;
    private JButton computeBill;
    private JButton view;
    private JTable info;

    public WaiterGUI(Restaurant restaurant) {
        this.restaurant = restaurant;
        frame = new JFrame();
        add = new JButton("Add order");
        computeBill = new JButton("Compute Bill for Order");
        view  = new JButton("View Orders");
        info = new JTable();

        frame.setLayout(new GridLayout(2, 3));
        frame.add(add);
        frame.add(computeBill);
        frame.add(view);
        frame.add(info);
        addListener();
        billListener();

        frame.setSize(800, 720);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private void addListener() {
        add.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter order information");
            if(input != null) {
                String[] values = input.split(" ");
                List<MenuItem> menuItemList = new ArrayList<>();
                for(int i = 1; i < values.length; i++) {
                    menuItemList.add(restaurant.getItem(values[1]));
                }
                restaurant.createNewOrder(Integer.parseInt(values[0]), menuItemList);
                restaurant.printOrders();
            }
        });
    }

    private void billListener() {
        computeBill.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter order number");
            if(input != null) {
                restaurant.generateBill(restaurant.getOrder(Integer.parseInt(input)));
            }
        });
    }
}
