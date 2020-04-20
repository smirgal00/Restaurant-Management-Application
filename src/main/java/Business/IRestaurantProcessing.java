package Business;

import java.util.Date;
import java.util.List;

public interface IRestaurantProcessing {

    /**
     * Adds given item to given menu
     * @pre item != null
     * @param item Item to be added to the menu
     */
    void addMenuItem(CompositeProduct item);

    /**
     * Deletes given item from given menu
     * @pre item != null
     * @param item Item to be deleted from menu
     */
    void deleteMenuItem(CompositeProduct item);

    /**
     * Searches for the given item and modifies it with its new attributes
     * @pre item != null
     * @pre newItem != null
     * @param item Item to be modified
     * @param newItem The item with new values changed
     */
    void editItem(CompositeProduct item, CompositeProduct newItem);

    /**
     * Searches for a product in the menu and adds a new item in it
     * @pre item != null
     * @pre product != null
     * @param item Item to be added to a product
     * @param product Product to be edited
     */
    void addItemToProduct(BaseProduct item, CompositeProduct product);

    /**
     * Creates and returns an order with given parameters
     * @post returns != null
     * @param ID Order ID
     * @param date Date of order
     * @param table Table
     * @return Order that was created
     */
    Order createOrder(Integer ID, Date date, Integer table);

    Double computePrice(Order order);

    void generateBill(Order order, Double price);

    void printMenu();
}
