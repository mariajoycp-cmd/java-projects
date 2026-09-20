class Student {
    String name;
    int age;

    // Default constructor
    Student() {
        name = "unknown";
        age = 0;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(); // Constructor is called automatically
        s1.display();
    }
}