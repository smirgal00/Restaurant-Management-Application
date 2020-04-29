package org.GUI;

import Business.BaseProduct;
import Business.MenuItem;
import Business.Restaurant;
import Data.Serializer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AdministratorGUI {
    private JFrame frame;
    private Restaurant restaurant;
    private JButton add;
    private JButton editComponent;
    private JButton editList;
    private JButton delete;
    private JButton view;
    private JTable info;
    private JButton save;
    private String file;

    public AdministratorGUI(Restaurant restaurant, String file) {
        this.file = file;
        this.restaurant = restaurant;
        frame = new JFrame();
        add = new JButton("Add Menu Item");
        editComponent = new JButton("Edit Menu Item");
        editList = new JButton("Edit List of Menu Items");
        delete = new JButton("Delete Menu Item");
        view  = new JButton("View Menu");
        save = new JButton("Save");
        info = new JTable();

        addListener();
        deleteListener();
        editListListener();
        editComponentListener();
        viewItemListener();
        saveListener();

        frame.setLayout(new GridLayout(2, 3));
        frame.add(add);
        frame.add(editComponent);
        frame.add(editList);
        frame.add(delete);
        frame.add(view);
        frame.add(save);

        frame.setSize(800, 720);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private void addListener() {
        add.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter menu item details!"); //nume pret ... Nume produs
            if(input != null) {
                String[] values = input.split(" ");
                List<MenuItem> menu = new ArrayList<>();

                for(int i = 0; i < values.length - 1; i += 2) {
                    menu.add(new BaseProduct(values[i], Double.parseDouble(values[i + 1])));
                }

                restaurant.createItem(menu, values[values.length - 1]);
            }
        });
    }

    private void deleteListener() {
        delete.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter menu item name to delete!");
            if(input != null) {
                restaurant.deleteItem(input);
            }
        });
    }

    private void editListListener() {
        editList.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter menu item details!"); //nume pret ... Nume produs
            if(input != null) {
                String[] values = input.split(" ");
                List<MenuItem> menu = new ArrayList<>();

                for(int i = 0; i < values.length - 1; i += 2) {
                    menu.add(new BaseProduct(values[i], Double.parseDouble(values[i + 1])));
                }

                restaurant.editMenuItem(menu, values[values.length - 1]);
            }
        });
    }

    private void editComponentListener() {
        editComponent.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter item to be edited and it modified");
            if(input != null) {
                String[] values = input.split(" ");

                restaurant.editMenuItem(new BaseProduct(
                        values[0], 0.0),
                        new BaseProduct(values[0], Double.parseDouble(values[1]))
                );
            }
        });
    }

    private void viewItemListener() {

        view.addActionListener(e -> {
            JFrame inf = new JFrame();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Product");
            info = new JTable(model);

            List<String> arr = restaurant.printMenuItems();

            for(String string : arr) {
                model.addRow(new String[] {string});
            }

            JScrollPane jScrollPane = new JScrollPane(info);
            inf.setSize(800, 720);
            inf.setResizable(false);
            inf.setVisible(true);
            inf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            inf.setLayout(new GridLayout(1, 1));
            inf.getContentPane().add(jScrollPane);
        });
    }

    private void saveListener() {
        save.addActionListener(e -> {
            Serializer ser = new Serializer(file);
            ser.serializeInfo(restaurant);
        });
    }
}