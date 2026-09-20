class Restaurant {
    static int totalOrders = 0;

    double calculateBill(double amount) {
        totalOrders++;
        return amount;
    }

    double calculateBill(double amount, double packingCharge) {
        totalOrders++;
        return amount + packingCharge;
    }

    double calculateBill(double amount, double deliveryCharge,
                         double packingCharge) {
        totalOrders++;
        return amount + deliveryCharge + packingCharge;
    }
}

public class Main {
    public static void main(String[] args) {
        Restaurant r = new Restaurant();

        System.out.println("Dine-In Bill: Rs." +
                r.calculateBill(1000));

        System.out.println("Takeaway Bill: Rs." +
                r.calculateBill(1000, 50));

        System.out.println("Delivery Bill: Rs." +
                r.calculateBill(1000, 100, 50));

        System.out.println("Total Orders: " +
                Restaurant.totalOrders);
    }
}