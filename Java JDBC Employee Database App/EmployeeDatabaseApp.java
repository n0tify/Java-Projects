import java.util.*;

public class EmployeeDatabaseApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeDatabase db = new EmployeeDatabase();

        while (true) {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = Double.parseDouble(scanner.nextLine());
                    Employee emp = new Employee(0, name, dept, salary);
                    db.addEmployee(emp);
                    break;

                case 2:
                    List<Employee> employees = db.getAllEmployees();
                    if (employees.isEmpty()) {
                        System.out.println("No employees found.");
                    } else {
                        for (Employee e : employees) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID to update salary: ");
                    int updateId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter new salary: ");
                    double newSalary = Double.parseDouble(scanner.nextLine());
                    db.updateEmployeeSalary(updateId, newSalary);
                    break;

                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    db.deleteEmployee(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting the application.");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

