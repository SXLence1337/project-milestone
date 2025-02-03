import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private Connection connection;

    // Constructor that establishes the connection to the PostgreSQL database
    public DatabaseManager() {
        try {
            // Make sure you provide your actual PostgreSQL database URL, username, and password here
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/yourdb", "yourusername", "yourpassword");
        } catch (SQLException e) {
            e.printStackTrace();  // Print the error if the connection fails
        }
    }

    // Method to insert an employee into the database
    public void insertEmployee(Employee employee) {
        String sql = "INSERT INTO employees (name, position, salary) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getPosition());
            stmt.setDouble(3, employee.getSalary());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();  // Print the error if something goes wrong during the insert
        }
    }

    // Method to fetch all employees from the database
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Employee employee = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("position"),
                        rs.getDouble("salary")
                );
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Print the error if something goes wrong during the query
        }
        return employees;
    }
}
