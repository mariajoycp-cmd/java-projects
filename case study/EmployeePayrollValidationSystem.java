class EmployeePayroll {
    String employeeId;
    String basicSalary;
    String bonus;

    EmployeePayroll(String id, String salary, String bonus) {
        this.employeeId = id;
        this.basicSalary = salary;
        this.bonus = bonus;
    }

    void calculateTotalSalary() {
        try {
            int id = Integer.parseInt(employeeId);
            int salary = Integer.parseInt(basicSalary);
            int bonusVal = Integer.parseInt(bonus);

            int totalSalary = salary + bonusVal;
            System.out.println("Employee ID: " + id);
            System.out.println("Total Salary: " + totalSalary);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for Employee ID " + employeeId + ": salary or bonus must be valid integers.");
        }
    }
}

public class EmployeePayrollValidationSystem {
    public static void main(String[] args) {
        EmployeePayroll e1 = new EmployeePayroll("101", "30000", "5000");
        EmployeePayroll e2 = new EmployeePayroll("102", "45000", "2500");
        EmployeePayroll e3 = new EmployeePayroll("103", "ABC", "3000");

        e1.calculateTotalSalary();
        System.out.println();
        e2.calculateTotalSalary();
        System.out.println();
        e3.calculateTotalSalary();
    }
}