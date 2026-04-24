package after.repository;

import after.model.Order;

// 🗄️ one job: persist the order
public class OrderRepository {

    public void save(Order order) {
        System.out.println("SQL › INSERT INTO orders VALUES ('"
                + order.id + "', " + order.total + ")");
    }
}