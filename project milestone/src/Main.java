import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseManager dbManager = new DatabaseManager();
        EmployeeManager employeeManager = new EmployeeManager(dbManager);

        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                    // Add employee
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();

                    // We don't pass 'id' here because the database will auto-generate it
                    Employee employee = new Employee(0, name, position, salary);  // '0' as placeholder for id
                    employeeManager.addEmployee(employee);
                    break;

                case 2:
                    // View all employees
                    employeeManager.displayAllEmployees();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}