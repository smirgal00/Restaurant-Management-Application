package Business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletionService;

public class Restaurant implements IRestaurantProcessing {

    List<CompositeProduct> menu;

    public Restaurant() {
        menu = new ArrayList<>();
    }

    @Override
    public void addMenuItem(CompositeProduct item) {
        assert item != null;
        assert menu != null;

        menu.add(item);

        assert menu.contains(item);
    }

    @Override
    public void deleteMenuItem(CompositeProduct item) {
        assert item != null;
        assert menu != null;

        menu.remove(item);

        assert !menu.contains(item);
    }

    @Override
    public void editItem(CompositeProduct item, CompositeProduct newItem) {
        assert item != null;
        assert newItem != null;
        assert !menu.isEmpty();

        int size = menu.size();

        menu.set(menu.indexOf(item), newItem);

        assert size == menu.size();
    }

    @Override
    public void addItemToProduct(BaseProduct item, CompositeProduct product) {
        assert item != null;
        assert product != null;
        assert menu.size() != 0;

        int size = menu.size();

        for(CompositeProduct compositeProduct : menu) {
            if(compositeProduct.equals(product)) {
                compositeProduct.addItem(item);
            }
        }

        assert size == menu.size();
    }

    @Override
    public Order createOrder(Integer ID, Date date, Integer table) {
        return null;
    }

    @Override
    public Double computePrice(Order order) {
        return null;
    }

    @Override
    public void generateBill(Order order, Double price) {

    }

    @Override
    public void printMenu() {
        for(CompositeProduct compositeProduct : menu) {
            System.out.println(compositeProduct.printProduct());
        }
    }
}
