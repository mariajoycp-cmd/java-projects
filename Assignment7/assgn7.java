interface Vehicle {
    void start();
}

class Car implements Vehicle {
    public void start() {
        System.out.println("Car is starting...");
    }
}

class ElectricCar extends Car {
    void charge() {
        System.out.println("Electric Car is charging...");
    }
}

public class assgn7 {
    public static void main(String[] args) {
        ElectricCar car = new ElectricCar();
        car.start();
        car.charge();
    }
}