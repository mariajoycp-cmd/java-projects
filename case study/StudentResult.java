import java.util.Scanner;

public class StudentResult {

    public static double calculateTotal(double m1, double m2, double m3) {
        return m1 + m2 + m3;
    }

    public static double calculateAverage(double total) {
        return total / 3.0;
    }

    public static String determineResult(double average) {
        if (average >= 40.0) {
            return "Pass";
        } else {
            return "Fail";
        }
    }

    public static void displayResult(String name, String rollNo, double m1, double m2, double m3) {
        double total = calculateTotal(m1, m2, m3);
        double average = calculateAverage(total);
        String result = determineResult(average);

        System.out.println("\n------------------------------------");
        System.out.println("          STUDENT RESULT            ");
        System.out.println("------------------------------------");
        System.out.println("Student Name : " + name);
        System.out.println("Roll Number  : " + rollNo);
        System.out.println("Marks        : " + m1 + ", " + m2 + ", " + m3);
        System.out.println("Total Marks  : " + total);
        System.out.println("Average Marks: " + average);
        System.out.println("Result Status: " + result);
        System.out.println("------------------------------------\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Roll Number: ");
        String rollNo = scanner.nextLine();

        System.out.print("Enter Subject 1 Marks: ");
        double m1 = scanner.nextDouble();

        System.out.print("Enter Subject 2 Marks: ");
        double m2 = scanner.nextDouble();

        System.out.print("Enter Subject 3 Marks: ");
        double m3 = scanner.nextDouble();

        displayResult(name, rollNo, m1, m2, m3);

        scanner.close();
    }
}
