interface FoodDelivery {
    void deliverFood(String customerName);

    default void trackOrder() {
        System.out.println("Food order is being tracked.");
    }
}

interface GroceryDelivery {
    void deliverGroceries(String customerName);

    default void trackOrder() {
        System.out.println("Grocery order is being tracked.");
    }

    static String generateDeliveryCode() {
        return "DLV-" + System.currentTimeMillis();
    }
}

class DeliveryExecutive implements FoodDelivery, GroceryDelivery {
    @Override
    public void deliverFood(String customerName) {
        System.out.println("Food delivered to " + customerName);
    }

    @Override
    public void deliverGroceries(String customerName) {
        System.out.println("Groceries delivered to " + customerName);
    }

    @Override
    public void trackOrder() {
        FoodDelivery.super.trackOrder();
        GroceryDelivery.super.trackOrder();
    }
}

public class FoodDeliveryPartnerSystem {
    public static void main(String[] args) {
        String[] customerNames = {"Arjun", "Priya", "Sana"};
        DeliveryExecutive executive = new DeliveryExecutive();

        executive.trackOrder();

        for (String customerName : customerNames) {
            String deliveryCode = GroceryDelivery.generateDeliveryCode();
            System.out.println("Delivery code for " + customerName + ": " + deliveryCode);
            executive.deliverFood(customerName);
            executive.deliverGroceries(customerName);
        }
    }
}
