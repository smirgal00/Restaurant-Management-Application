package Business;

import Data.FileWriting;
import org.GUI.ChefGUI;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

@SuppressWarnings("deprecation")
/**
 * Restaurant class that contains a menu and a map of orders.
 *
 * @inv menu != null
 * @inv Orders != null
 * @inv orderId >= 0
 */
public class Restaurant extends Observable implements IRestaurantProcessing, Serializable {

    private List<MenuItem> menu;
    private Map<Order, List<MenuItem>> Orders;
    private Integer orderId;
    private ChefGUI chefGUI;

    @SuppressWarnings("ConstantConditions")
    public Restaurant() {
        menu = new ArrayList<>();
        Orders = new HashMap<>();
        orderId = 0;

        wellformed();
    }

    private void wellformed() {
        assert menu != null;
        assert Orders != null;
        assert orderId >= 0;
    }

    private void alert() {
        setChanged();
        notifyObservers();
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
            String[] temp = menuItem.getName().split(":");
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
            String[] split = menuItem.getName().split(":");
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

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Order order = new Order(++orderId, dateFormat.format(new Date()), table);

        Orders.put(order, menu);

        alert();
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

    public List<String> printMenuItems() {
        StringBuilder sb = new StringBuilder();
        List<String> arr = new ArrayList<>();
        for(MenuItem menuItem : menu) {
            sb.delete(0, sb.length());
            sb.append(menuItem.getName()).append(" Price: ").append(menuItem.computePrice());
            arr.add(sb.toString());
        }

        return arr;
    }

    public Order getOrder(int i) {
        for(Order order : Orders.keySet()) {
            if(order.getID() == i) {
                return order;
            }
        }

        return null;
    }

    public Integer getOrderNumber() {
        return this.orderId;
    }

    public MenuItem getItem(String name) {
        for(MenuItem menuItem : menu) {
            if(menuItem.getName().split(":")[0].equals(name)) {
                return menuItem;
            }
        }
        return null;
    }

    public String getOrderProducts(Order order) {
        StringBuilder prod = new StringBuilder();

        for(Order order1 : Orders.keySet()) {
            if(order1.equals(order)) {
                List<MenuItem> menuItem = Orders.get(order);
                for(MenuItem mt : menuItem) {
                    prod.append(mt.getName().split("\n")[0]).append(" ");
                }
            }
        }

        return prod.toString();
    }

    public String printOrders() {
        StringBuilder sb = new StringBuilder();
        for(Entry<Order, List<MenuItem>> entry : Orders.entrySet()) {
            sb.append(entry.getKey().tableInfo()).append(" Price: ").append(computePrice(entry.getKey()));
            for(MenuItem menuItem1 : entry.getValue()) {
                sb.append(menuItem1.getName()).append(" ").append(menuItem1.computePrice());
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
