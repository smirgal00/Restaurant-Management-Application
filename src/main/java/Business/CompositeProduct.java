package Business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CompositeProduct extends MenuItem implements Serializable {
    private final String name;
    private List<MenuItem> product;

    public CompositeProduct(String name) {
        this.name = name;
        product = new ArrayList<>();
    }

    public CompositeProduct(String name, List<MenuItem> product) {
        this.name = name;
        this.product = product;
    }

    @Override
    public Double computePrice() {
        Double price = 0.0;

        for (MenuItem menuItem : product) {
            price += menuItem.computePrice();
        }

        return price;
    }

    @Override
    public String getName() {
        StringBuilder name = new StringBuilder(this.name + ": ");

        for (MenuItem menuItem : product) {
            name.append(menuItem.getName()).append(", ");
        }

        name.replace(name.length() - 2, name.length(), "");

        return name.toString();
    }

    @Override
    public void addItem(MenuItem menuItem) {
        for(MenuItem menuItem1 : product) {
            if(menuItem1.getName().equals(menuItem.getName())) {
                menuItem1.setPrice(menuItem.computePrice());
                return;
            }
        }
        if(!product.contains(menuItem)) {
            product.add(menuItem);
        }
    }

    @Override
    public void editItem(MenuItem menuItem) {
        for(MenuItem menuItem1 : product) {
            if(menuItem1.getName().equals(menuItem.getName())) {
                menuItem1.editItem(menuItem);
            }
        }
    }

    @Override
    public void setPrice(Double price) {
        throw new java.lang.UnsupportedOperationException("This operation is not supported!");
    }
}