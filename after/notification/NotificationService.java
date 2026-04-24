package after.notification;

import after.model.Order;

// 🔔 one job: tell the customer their order is in
public class NotificationService {

    public void notify(Order order) {
        System.out.println("SMS  → " + order.phone + ": your order " + order.id + " is placed ✓");
        System.out.println("Mail → " + order.email + ": order confirmation — " + order.id);
    }
}