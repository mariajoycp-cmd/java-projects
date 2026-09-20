import java.util.ArrayList;
import java.util.Vector;

public class CollectionDemo {

    public static void main(String[] args) {

        // ArrayList
        ArrayList<String> students = new ArrayList<>();

        students.add("Maria");
        students.add("Rahul");
        students.add("Priya");

        System.out.println("ArrayList:");
        System.out.println(students);

        // Vector
        Vector<Integer> numbers = new Vector<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println("\nVector:");
        System.out.println(numbers);

        // StringBuffer
        StringBuffer sb = new StringBuffer("Java");

        sb.append(" Programming");

        System.out.println("\nStringBuffer:");
        System.out.println(sb);
    }
}