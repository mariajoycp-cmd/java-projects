public class Order {
    private static int totalOrders = 0;
    private static double totalRevenue = 0.0;

    public double calculateBill(double price) {
        double bill = price;
        totalOrders++;
        totalRevenue += bill;
        return bill;
    }

    public double calculateBill(double price, int quantity) {
        double bill = price * quantity;
        totalOrders++;
        totalRevenue += bill;
        return bill;
    }

    public double calculateBill(double price, int quantity, double deliveryCharge) {
        double bill = (price * quantity) + deliveryCharge;
        totalOrders++;
        totalRevenue += bill;
        return bill;
    }

    public static void displaySummary() {
        System.out.printf("Total Orders: %d%n", totalOrders);
        System.out.printf("Total Revenue: %.2f%n", totalRevenue);
    }

    public static void main(String[] args) {
        Order order = new Order();

        double bill1 = order.calculateBill(500);
        System.out.printf("TC1 Output: %.2f%n", bill1);

        double bill2 = order.calculateBill(250, 3);
        System.out.printf("TC2 Output: %.2f%n", bill2);

        double bill3 = order.calculateBill(250, 3, 50);
        System.out.printf("TC3 Output: %.2f%n", bill3);

        Order.displaySummary();
    }
}