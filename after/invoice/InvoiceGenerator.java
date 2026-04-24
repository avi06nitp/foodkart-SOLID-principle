package after.invoice;

import after.model.Item;
import after.model.Order;

// 🧾 one job: print the bill
public class InvoiceGenerator {

    public void print(Order order) {
        System.out.println("\n────── INVOICE ──────");
        for (Item i : order.items)
            System.out.printf("  %-15s x%d  ₹%.0f%n", i.name, i.qty, i.price * i.qty);
        System.out.printf("  %-15s     ₹%.0f%n", "TOTAL", order.total);
        System.out.println("─────────────────────\n");
    }
}