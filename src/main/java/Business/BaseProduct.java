package Business;

import java.io.Serializable;

public class BaseProduct extends MenuItem implements Serializable {
    private String name;
    private Double price;

    public BaseProduct(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public Double computePrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addItem(MenuItem menuItem) {
        throw new java.lang.UnsupportedOperationException("This operation is not supported!");
    }

    @Override
    public void editItem(MenuItem menuItem) {
        this.name = menuItem.getName();
        this.price = menuItem.computePrice();
    }

    @Override
    public void setPrice(Double price) {
        this.price = price;
    }
}
