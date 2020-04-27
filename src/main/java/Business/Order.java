package Business;

import java.util.Date;

public class Order {
    private Integer ID;
    private Date date;
    private Integer table;

    public Order(Integer ID, Date date, Integer table) {
        this.ID = ID;
        this.date = date;
        this.table = table;
    }

    @Override
    public int hashCode() {
        return (ID + date.hashCode() + table);
    }
    
    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTable(Integer table) {
        this.table = table;
    }

    public Integer getID() {
        return ID;
    }

    public Date getDate() {
        return date;
    }

    public Integer getTable() {
        return table;
    }
}
