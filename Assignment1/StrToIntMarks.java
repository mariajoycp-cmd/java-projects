import java.util.Scanner;

public class StrToIntMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks for Sub1: ");
        String mark1 = sc.nextLine();
        System.out.print("Enter marks for Sub2:");
        String mark2 = sc.nextLine();
        System.out.print("Enter marks for Sub3:");
        String mark3 = sc.nextLine();
        int m1 = Integer.parseInt(mark1);
        int m2 = Integer.parseInt(mark2);
        int m3 = Integer.parseInt(mark3);
        int total = m1 + m2 + m3;
        System.out.println("Sub1 marks: " + m1);
        System.out.println("Sub2 marks: " + m2);
        System.out.println("Sub3 marks: " + m3);
        System.out.println("Total marks: " + total);
    }
}