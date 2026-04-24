package after.payment;

// 💳 one job: charge the customer
public class PaymentProcessor {

    public void charge(String method, double amount) {
        switch (method) {
            case "CARD" -> System.out.println("→ Razorpay: charging ₹" + amount);
            case "UPI"  -> System.out.println("→ UPI: charging ₹" + amount);
            case "COD"  -> System.out.println("→ COD: collect ₹" + amount + " at delivery");
            default     -> throw new IllegalArgumentException("unknown payment: " + method);
        }
    }
}