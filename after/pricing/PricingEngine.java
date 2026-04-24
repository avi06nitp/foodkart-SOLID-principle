package after.pricing;

import after.model.Item;
import java.util.List;

// 💰 one job: figure out what the customer pays
public class PricingEngine {

    public double calculate(List<Item> items) {
        double total = items.stream()
                .mapToDouble(i -> i.price * i.qty)
                .sum();

        if (total > 500)          return total * 0.90;  // 10% off
        if (items.size() > 5)     return total - 50;    // bulk discount
        return total;
    }
}