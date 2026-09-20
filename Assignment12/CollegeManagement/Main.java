import student.Student;
import faculty.Faculty;

public class Main {
    public static void main(String[] args) {

        Student s = new Student(101, "Rahul", "Computer Engineering");

        Faculty f = new Faculty(501, "Dr. Sharma", "Computer Engineering");

        s.displayStudent();

        System.out.println();

        f.displayFaculty();
    }
}