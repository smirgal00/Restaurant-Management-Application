package org.GUI;

import Business.Order;
import Business.Restaurant;
import Business.MenuItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
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
        view = new JButton("View Orders");
        info = new JTable();

        frame.setLayout(new GridLayout(2, 3));
        frame.add(add);
        frame.add(computeBill);
        frame.add(view);
        addListener();
        billListener();
        setJTable();
        frame.add(info);


        frame.setSize(800, 720);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private void addListener() {
        add.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter order information");
            if (input != null) {
                String[] values = input.split(" ");
                List<MenuItem> menuItemList = new ArrayList<>();
                for (int i = 1; i < values.length; i++) {
                    menuItemList.add(restaurant.getItem(values[i]));
                }
                restaurant.createNewOrder(Integer.parseInt(values[0]), menuItemList);
            }
        });
    }

    private void billListener() {
        computeBill.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter order number");
            if (input != null) {
                restaurant.generateBill(restaurant.getOrder(Integer.parseInt(input)));
            }
        });
    }

    private void setJTable() {
        view.addActionListener(e -> {
            DefaultTableModel model = new DefaultTableModel();
            String[] column = {"ID", "Date", "Table", "Products", "Price"};

            for (String string : column) {
                model.addColumn(string);
            }

            info = new JTable(model);

            JFrame vieww = new JFrame();
            vieww.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            vieww.setLayout(new GridLayout(1, 1));
            restaurant.printOrders();

            vieww.setSize(800, 720);
            vieww.setResizable(false);
            vieww.setVisible(true);

            JScrollPane jScrollPane = new JScrollPane(info);
            vieww.getContentPane().add(jScrollPane);

            for(int i = 1; i <= restaurant.getOrderNumber(); i++) {
                Order order = restaurant.getOrder(i);
                model.addRow(new String[] {String.valueOf(order.getID()), order.getDate(),
                        String.valueOf(order.getTable()), restaurant.getOrderProducts(order),
                        String.valueOf(restaurant.computePrice(order))
                });
            }

            restaurant.printMenuItems();

        });
    }
}
