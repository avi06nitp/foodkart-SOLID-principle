package after.service;

import after.invoice.InvoiceGenerator;
import after.model.Item;
import after.model.Order;
import after.notification.NotificationService;
import after.payment.PaymentProcessor;
import after.pricing.PricingEngine;
import after.repository.OrderRepository;
import after.validation.CustomerValidator;

import java.util.List;

// 🎯 one job: orchestrate — nothing more
public class OrderService {

    private final CustomerValidator   validator = new CustomerValidator();
    private final PricingEngine       pricing   = new PricingEngine();
    private final PaymentProcessor    payment   = new PaymentProcessor();
    private final OrderRepository     repo      = new OrderRepository();
    private final NotificationService notifier  = new NotificationService();
    private final InvoiceGenerator    invoice   = new InvoiceGenerator();

    public void placeOrder(String phone, String email,
                           List<Item> items, String paymentMethod) {

        validator.validate(phone, items);

        double total = pricing.calculate(items);
        payment.charge(paymentMethod, total);

        Order order = new Order(
            "ORD-" + System.currentTimeMillis(),
            phone, email, items, total, paymentMethod
        );

        repo.save(order);
        notifier.notify(order);
        invoice.print(order);
    }
}