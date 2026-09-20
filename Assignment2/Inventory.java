class Mobile {
    String brand;
    double price;
    int quantity;

    // default
    Mobile() {
        brand = "Unknown";
        price = 0.0;
        quantity = 0;
    }

    // parameterized
    Mobile(String brand, double price, int quantity) {
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
    }

    
    Mobile(String brand) {
        this.brand = brand;
        this.price = 0.0;
        this.quantity = 0;
    }

    // copy
    Mobile(Mobile m) {
        this.brand = m.brand;
        this.price = m.price;
        this.quantity = m.quantity;
    }

    void display() {
        System.out.println("brand    : " + brand);
        System.out.println("price    : " + price);
        System.out.println("quantity : " + quantity);
       }
}
public class Inventory {
    public static void main(String[] args) {

        // default 
        Mobile m1 = new Mobile();

        // parameterized
        Mobile m2 = new Mobile("Samsung", 9299, 10);

        // copy 
        Mobile m3 = new Mobile(m2);

        // display
        System.out.println(" 1:");
        m1.display();

        System.out.println(" 2:");
        m2.display();

        System.out.println(" 4 :");
        m3.display();
    }
}