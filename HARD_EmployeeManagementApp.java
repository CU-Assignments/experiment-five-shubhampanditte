import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private String name;
    private int employeeId;
    private String designation;
    private double salary;

    public Employee(String name, int employeeId, String designation, double salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.designation = designation;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getDesignation() {
        return designation;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + employeeId + ", name='" + name + "', designation='" + designation + "', salary=" + salary + "}";
    }
}

public class EmployeeManagementApp {
    private static final String FILE_NAME = "employees.dat";

    public static void addEmployee() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Employee Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Employee ID:");
        int employeeId = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Enter Designation:");
        String designation = scanner.nextLine();

        System.out.println("Enter Salary:");
        double salary = scanner.nextDouble();

        Employee employee = new Employee(name, employeeId, designation, salary);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME, true))) {
            out.writeObject(employee);
            System.out.println("Employee added successfully!");
        } catch (IOException e) {
            System.err.println("Error saving employee: " + e.getMessage());
        }
    }

    public static void displayAllEmployees() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Object obj;
            while ((obj = in.readObject()) != null) {
                if (obj instanceof Employee) {
                    Employee employee = (Employee) obj;
                    System.out.println(employee);
                }
            }
        } catch (EOFException e) {
            
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading employees: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        while (true) {
          
            System.out.println("\nEmployee Management Menu:");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine();  

            switch (option) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    System.out.println("\nEmployee List:");
                    displayAllEmployees();
                    break;
                case 3:
                    System.out.println("Exiting application...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
