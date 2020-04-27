package Business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Restaurant implements IRestaurantProcessing {

    private List<MenuItem> menu;

    public Restaurant() {
        menu = new ArrayList<>();
    }

    @Override
    public void createItem(List<MenuItem> components, String name) {
        assert components.size() != 0 : "The list of components is empty! Function: createItem from Restaurant class";
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

            if(menuItem.getName().equals(name)) {
                menu.remove(menuItem);
            }
        }
    }

    @Override
    public void editMenuItem(List<MenuItem> components, String name) {
        assert components.size() != 0;
        assert name != null;

        for(MenuItem menuItem : menu) {
            String[] split= menuItem.getName().split("\n");
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

    public void printMenuItems() {
        for(MenuItem menuItem : menu) {
            System.out.println(menuItem.getName() + " Price: " + menuItem.computePrice());
        }
    }
}
