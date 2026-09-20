class Mobile {
    String brand;
    String model;
    double price;

    Mobile() {
        brand = "Unknown";
        model = "Unknown";
        price = 0;
    }

    Mobile(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    Mobile(Mobile m) {
        this.brand = m.brand;
        this.model = m.model;
        this.price = m.price;
    }

    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: Rs." + price);
    }
}

class Main {
    public static void main(String[] args) {
        Mobile m1 = new Mobile("Samsung", "Galaxy S24", 70000);
        Mobile m2 = new Mobile(m1);

        System.out.println("Original Mobile:");
        m1.display();

        System.out.println("\nDuplicate Mobile:");
        m2.display();
    }
}