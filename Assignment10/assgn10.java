abstract class Shape {
    abstract void draw();

    void message() {
        System.out.println("Drawing Shape");
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing Circle");
    }
}

public class assgn10 {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.message();
        c.draw();
    }
}