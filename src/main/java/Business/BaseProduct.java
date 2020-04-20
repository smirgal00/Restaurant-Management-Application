package Business;

import java.util.List;

public class BaseProduct implements MenuItem {
    private final String name;
    private final Double price;

    public BaseProduct(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public Double computePrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }
}
