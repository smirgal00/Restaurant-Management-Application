package Business;

import java.util.ArrayList;
import java.util.List;

public class CompositeProduct implements MenuItem {
    private final String name;

    List<BaseProduct> items;

    public CompositeProduct(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    @Override
    public Double computePrice() {
        Double price = 0.0;

        for(MenuItem item : items) {
            price += item.computePrice();
        }

        return price;
    }

    @Override
    public boolean equals(Object product) {
        CompositeProduct compositeProduct = (CompositeProduct) product;

        return compositeProduct.getName() == this.name;
    }

    public String getName() {
        return this.name;
    }

    public void addItem(BaseProduct item) {
        if(!items.contains(item)) {
            items.add(item);
        }

    }

    public String printProduct() {
        String text = "";
        for(BaseProduct item : items) {
            text = text + item.getName() + ", ";
        }
        return text;
    }


}
