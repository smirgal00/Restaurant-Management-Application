package Business;

public abstract class MenuItem {

    public abstract Double computePrice();
    public abstract String getName();
    public abstract void addItem(MenuItem menuItem);
    public abstract void editItem(MenuItem menuItem);
}
