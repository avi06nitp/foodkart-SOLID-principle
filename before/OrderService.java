package before;

import java.util.List;

/*
 * ⚠️  How many reasons does this class have to change?
 *
 *   1. validation rules change
 *   2. discount logic changes
 *   3. new payment method added
 *   4. we switch from MySQL to Mongo
 *   5. we add WhatsApp notifications
 *   6. invoice format changes
 *
 * Answer: 6. One class, six reasons. That's the problem.
 */
public class OrderService {

    public void placeOrder(String phone, String email,
                           List<Item> items, String paymentMethod) {

        // ── 1. validate ──────────────────────────────────────────────────
        if (phone == null || phone.isBlank())
            throw new IllegalArgumentException("phone required");
        if (items == null || items.isEmpty())
            throw new IllegalArgumentException("cart is empty");

        // ── 2. calculate price ────────────────────────────────────────────
        double total = 0;
        for (Item i : items) total += i.getPrice() * i.getQty();

        if (total > 500)           total *= 0.90;  // 10% off for big orders
        else if (items.size() > 5) total -= 50;    // bulk discount

        // ── 3. process payment ────────────────────────────────────────────
        if (paymentMethod.equals("CARD")) {
            System.out.println("→ Razorpay: charging ₹" + total);
        } else if (paymentMethod.equals("UPI")) {
            System.out.println("→ UPI: charging ₹" + total);
        } else if (paymentMethod.equals("COD")) {
            System.out.println("→ COD: collect ₹" + total + " at delivery");
        } else {
            throw new IllegalArgumentException("unknown payment: " + paymentMethod);
        }

        // ── 4. save to database ───────────────────────────────────────────
        String orderId = "ORD-" + System.currentTimeMillis();
        System.out.println("SQL › INSERT INTO orders VALUES ('" + orderId + "', " + total + ")");

        // ── 5. send notifications ─────────────────────────────────────────
        System.out.println("SMS  → " + phone + ": your order " + orderId + " is placed ✓");
        System.out.println("Mail → " + email + ": order confirmation — " + orderId);

        // ── 6. generate invoice ───────────────────────────────────────────
        System.out.println("\n────── INVOICE ──────");
        for (Item i : items)
            System.out.printf("  %-15s x%d  ₹%.0f%n",
                    i.getName(), i.getQty(), i.getPrice() * i.getQty());
        System.out.printf("  %-15s     ₹%.0f%n", "TOTAL", total);
        System.out.println("─────────────────────\n");
    }
}