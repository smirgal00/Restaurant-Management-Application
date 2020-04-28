package Business;

import javafx.scene.chart.PieChart;

import java.util.DuplicateFormatFlagsException;
import java.util.List;

public interface IRestaurantProcessing {

    /**
     * Creates a new menu item based on the list of ingredients provided as a parameter
     *
     * @pre components.size() != 0
     * @pre name != null
     * @param components Ingredients of menu item
     * @param name Name of menu item
     */
    void createItem(List<MenuItem> components, String name);

    /**
     * Deletes an item from the given menu
     *
     * @pre name != null
     * @param name The item that will be deleted
     */
    void deleteItem(String name);

    /**
     * Searches for the given product name as a parameter and adds base products to it
     *
     * @pre components.size() != 0
     * @pre name != null
     * @param components New base products an item contains
     * @param name Name of the product to be edited
     */
    void editMenuItem(List<MenuItem> components, String name);

    /**
     * Searches for all the products that contain the given component and changes their details
     * @pre component != null
     * @pre newComponent != null
     * @param component components that needs to be edited
     */
    void editMenuItem(MenuItem component, MenuItem newComponent);

    /**
     * Creates a new order with the next ID, current date and its respective table
     * @pre menu.size() != 0
     * @param table The table to which the order is assigned
     */
    void createNewOrder(Integer table, List<MenuItem> menu);

    /**
     * Calculates the price for the given order if it exists
     * @pre order != null
     * @param order Order whose price must be calculated
     * @return The price
     */
    Double computePrice(Order order);

    /**
     * Generates bill for the given order
     * @pre order != null
     * @param order Given order for the bill
     */
    void generateBill(Order order);

}
