class Outer {
    private String message = "Welcome to Java Programming";
    // Inner Class
    class Inner {
        void display() {
            System.out.println("Message: " + message);
        }
    }
}

interface Greeting {
    void sayHello();
}

public class InnerAnonymousDemo {
    public static void main(String[] args) {
        // Inner Class
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.display();

        // Anonymous Class
        Greeting greet = new Greeting() {
            public void sayHello() {
                System.out.println("Hello from Anonymous Class");
            }
        };
        greet.sayHello();
    }
}
