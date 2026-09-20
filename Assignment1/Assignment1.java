public class Assignment1 {

    String name;
    int age;

    Assignment1(String n, int a) {
        name = n;
        age = a;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        Assignment1 s1 = new Assignment1("Maria Joy", 19);
        s1.display();
    }
}