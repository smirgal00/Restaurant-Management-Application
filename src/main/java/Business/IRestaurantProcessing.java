package Business;

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
}
