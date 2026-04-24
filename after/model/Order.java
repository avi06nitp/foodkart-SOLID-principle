package after.model;

import java.util.List;

public class Order {
    public final String     id;
    public final String     phone;
    public final String     email;
    public final List<Item> items;
    public final double     total;
    public final String     paymentMethod;

    public Order(String id, String phone, String email,
                 List<Item> items, double total, String paymentMethod) {
        this.id            = id;
        this.phone         = phone;
        this.email         = email;
        this.items         = items;
        this.total         = total;
        this.paymentMethod = paymentMethod;
    }
}