package after.model;

public class Item {
    public final String name;
    public final double price;
    public final int    qty;

    public Item(String name, double price, int qty) {
        this.name  = name;
        this.price = price;
        this.qty   = qty;
    }
}