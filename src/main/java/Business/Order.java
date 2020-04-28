package Business;

import java.util.Date;

public class Order {
    private Integer ID;
    private String date;
    private Integer table;

    public Order(Integer ID, String date, Integer table) {
        this.ID = ID;
        this.date = date;
        this.table = table;
    }

    @Override
    public int hashCode() {
        return (ID + date.hashCode() + table);
    }

    @Override
    public boolean equals(Object order) {
        if (order == this) {
            return true;
        }

        if (!(order instanceof Order)) {
            return false;
        }

        Order order1 = (Order) order;

        return order1.getID().equals(ID) && order1.getDate().equals(date) && order1.getTable().equals(table);
    }

    public String tableInfo() {
        return "Order ID: " + ID + " " + date + " " + "Table No: " + table;
    }

    public Integer getID() {
        return ID;
    }

    public String getDate() {
        return date;
    }

    public Integer getTable() {
        return table;
    }
}
