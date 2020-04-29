package Business;

import Data.FileWriting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

/**
 * Restaurant class that contains a menu and a map of orders.
 *
 * @inv menu != null
 * @inv Orders != null
 * @inv orderId >= 0
 */
public class Restaurant implements IRestaurantProcessing, Serializable {

    private List<MenuItem> menu;
    private Map<Order, List<MenuItem>> Orders;
    private Integer orderId;

    @SuppressWarnings("ConstantConditions")
    public Restaurant() {
        menu = new ArrayList<>();
        Orders = new HashMap<>();
        orderId = 0;

        assert menu != null;
        assert Orders != null;
        assert orderId >= 0;
    }

    @Override
    public void createItem(List<MenuItem> components, String name) {
        assert components.size() != 0;
        assert name != null;

        int size = menu.size();

        MenuItem temp = new CompositeProduct(name);
        for(MenuItem menuItem : components) {
            temp.addItem(menuItem);
        }

        menu.add(temp);

        assert menu.size() == size + 1;
    }

    @Override
    public void deleteItem(String name) {

        assert name != null;

        Iterator<MenuItem> iterator = menu.iterator();

        while(iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            String[] temp = menuItem.getName().split("\n");
            if(temp[0].equals(name)) {
                iterator.remove();
            }
        }
    }

    @Override
    public void editMenuItem(List<MenuItem> components, String name) {
        assert components.size() != 0;
        assert name != null;

        for(MenuItem menuItem : menu) {
            String[] split = menuItem.getName().split("\n");
            if(split[0].equals(name)) {
                for(MenuItem comp : components) {
                    menuItem.addItem(comp);
                }
            }
        }
    }

    @Override
    public void editMenuItem(MenuItem component, MenuItem newComponent) {
        assert component != null;
        assert newComponent != null;

        for(MenuItem menuItem : menu) {
           menuItem.editItem(newComponent);
        }
    }

    @Override
    public void createNewOrder(Integer table, List<MenuItem> menu) {
        assert menu.size() != 0;
        for(MenuItem menuItem : menu) {
            assert this.menu.contains(menuItem);
        }

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Order order = new Order(++orderId, dateFormat.format(new Date()), table);

        Orders.put(order, menu);
    }

    @Override
    public Double computePrice(Order order) {
        assert order != null;
        Double price = 0.0;

        for(MenuItem menuItem : Orders.get(order)) {
            price += menuItem.computePrice();
        }

        return price;
    }

    @Override
    public void generateBill(Order order) {
        assert order != null;

        String title = "Bill for Order " + order.getID() + ".txt";

        StringBuilder sb = new StringBuilder();
        sb.append(order.tableInfo()).append(" Price: ").append(computePrice(order));

        List<MenuItem> ing = Orders.get(order);
        for(MenuItem menuItem : ing) {
            sb.append("\n").append(menuItem.getName()).append(" Price: ").append(menuItem.computePrice());
        }

        FileWriting fw = new FileWriting();
        fw.generateBill(title, sb.toString());

    }

    public void printMenuItems() {
        for(MenuItem menuItem : menu) {
            System.out.println(menuItem.getName() + " Price: " + menuItem.computePrice());
        }
    }

    public Order getOrder(int i) {
        for(Order order : Orders.keySet()) {
            if(order.getID() == i) {
                return order;
            }
        }

        return null;
    }

    public MenuItem getItem(String name) {
        for(MenuItem menuItem : menu) {
            if(menuItem.getName().split("\n")[0].equals(name)) {
                return menuItem;
            }
        }

        return null;
    }

    public void printOrders() {
        for(Entry<Order, List<MenuItem>> entry : Orders.entrySet()) {
            System.out.println(entry.getKey().tableInfo() + " Price: " + computePrice(entry.getKey()));
            for(MenuItem menuItem1 : entry.getValue()) {
                System.out.println(menuItem1.getName() + " " + menuItem1.computePrice());
            }
        }
    }
}
