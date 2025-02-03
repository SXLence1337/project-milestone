import java.util.List;
import java.util.ArrayList;

public class EmployeeManager {
    private DatabaseManager dbManager;

    // Constructor
    public EmployeeManager(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    // Method to add an employee
    public void addEmployee(Employee employee) {
        dbManager.insertEmployee(employee);  // Insert the employee into the database
    }

    // Method to display all employees
    public void displayAllEmployees() {
        List<Employee> employees = dbManager.getAllEmployees();  // Retrieve all employees from the database
        for (Employee employee : employees) {
            System.out.println(employee);  // Display each employee's details
        }
    }
}