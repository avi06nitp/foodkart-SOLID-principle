package after.validation;

import after.model.Item;
import java.util.List;

// ✅ one job: guard the inputs
public class CustomerValidator {

    public void validate(String phone, List<Item> items) {
        if (phone == null || phone.isBlank())
            throw new IllegalArgumentException("phone required");
        if (items == null || items.isEmpty())
            throw new IllegalArgumentException("cart is empty");
    }
}