package after;

import after.model.Item;
import after.service.OrderService;

import java.util.List;

public class FoodKartApp {

    public static void main(String[] args) {
        OrderService svc = new OrderService();

        svc.placeOrder(
            "9876543210",
            "raj@example.com",
            List.of(
                new Item("Burger",  149, 2),
                new Item("Fries",    59, 1),
                new Item("Cola",     49, 2)
            ),
            "UPI"
        );
    }
}