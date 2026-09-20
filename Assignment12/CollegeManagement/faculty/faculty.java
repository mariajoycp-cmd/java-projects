package faculty;

public class Faculty {
    int facultyId;
    String name;
    String department;

    public Faculty(int facultyId, String name, String department) {
        this.facultyId = facultyId;
        this.name = name;
        this.department = department;
    }

    public void displayFaculty() {
        System.out.println("Faculty Details");
        System.out.println("Faculty ID : " + facultyId);
        System.out.println("Name       : " + name);
        System.out.println("Department : " + department);
    }
}