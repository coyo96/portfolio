import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private String name;
    private String email;
    private String phoneNumber;
    private double annualSalary;
    private LocalDate hireDate;
    private LocalDate terminationDate;

    public Employee(String name, String email, String phoneNumber, double annualSalary, LocalDate hireDate) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.annualSalary = annualSalary;
        this.hireDate = hireDate;
    }

    public Employee(String name, String email, String phoneNumber, double annualSalary, LocalDate hireDate, LocalDate terminationDate) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.annualSalary = annualSalary;
        this.hireDate = hireDate;
        this.terminationDate = terminationDate;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public LocalDate getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(LocalDate terminationDate) {
        this.terminationDate = terminationDate;
    }

    public boolean isTerminated() {
        return terminationDate != null;
    }

    @Override
    public String toString() {
        StringBuilder employeeDetails = new StringBuilder();
        employeeDetails.append("Name: ").append(name).append("\nEmail: ").append(email)
                .append("\nPhone Number: ").append(phoneNumber).append("\nAnnual Salary: ").append(annualSalary)
                .append("\nHire Date: ").append(hireDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        if (isTerminated()) {
            employeeDetails.append("\nTermination Date: ").append(terminationDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        }
        return employeeDetails.toString();
    }
}

class HRManagementSystem {
    private List<Employee> employees;
    private List<Employee> pastEmployees;

    public HRManagementSystem() {
        employees = new ArrayList<>();
        pastEmployees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    public void editEmployee() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        listAllEmployees();

        System.out.print("Enter the name of the employee to edit: ");
        String name = scanner.nextLine();

        Employee employeeToEdit = findEmployeeByName(name, employees);
        if (employeeToEdit != null) {
            System.out.println("Employee found. Enter new information:");

            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();
            employeeToEdit.setName(newName);

            System.out.print("Enter new email: ");
            String newEmail = scanner.nextLine();
            employeeToEdit.setEmail(newEmail);

            System.out.print("Enter new phone number: ");
            String newPhoneNumber = scanner.nextLine();
            employeeToEdit.setPhoneNumber(newPhoneNumber);

            System.out.print("Enter new annual salary: ");
            double newAnnualSalary = scanner.nextDouble();
            employeeToEdit.setAnnualSalary(newAnnualSalary);

            System.out.print("Enter new hire date (MM/dd/yyyy): ");
            String newHireDateStr = scanner.next();
            LocalDate newHireDate = LocalDate.parse(newHireDateStr, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
            employeeToEdit.setHireDate(newHireDate);

            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void terminateEmployee() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        listAllEmployees();

        System.out.print("Enter the name of the employee to terminate: ");
        String name = scanner.nextLine();

        Employee employeeToTerminate = findEmployeeByName(name, employees);
        if (employeeToTerminate != null) {
            System.out.print("Enter termination date (MM/dd/yyyy): ");
            String terminationDateStr = scanner.nextLine();
            LocalDate terminationDate = LocalDate.parse(terminationDateStr, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
            employeeToTerminate.setTerminationDate(terminationDate);

            pastEmployees.add(employeeToTerminate);
            employees.remove(employeeToTerminate);

            System.out.println("Employee terminated successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void viewEmployeeInformation() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        listAllEmployees();

        System.out.print("Enter the name of the employee to view information: ");
        String name = scanner.nextLine();

        Employee employee = findEmployeeByName(name, employees);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }
    }

    private Employee findEmployeeByName(String name, List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            if (employee.getName().equalsIgnoreCase(name)) {
                return employee;
            }
        }
        return null;
    }

    private void listAllEmployees() {
        System.out.println("=== Employees ===");
        for (Employee employee : employees) {
            System.out.println(employee);
            System.out.println("----------------------------");
        }
    }

    public void printAllEmployees() {
        listAllEmployees();
        if (pastEmployees.isEmpty()) {
            System.out.println("No past employees found.");
        } else {
            System.out.println("=== Past Employees ===");
            for (Employee pastEmployee : pastEmployees) {
                System.out.println(pastEmployee);
                System.out.println("----------------------------");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HRManagementSystem hrms = new HRManagementSystem();

        while (true) {
            System.out.println("\n========== HR Management System ==========");
            System.out.println("1. Add Employee");
            System.out.println("2. Edit Employee");
            System.out.println("3. Terminate Employee");
            System.out.println("4. View Employee Information");
            System.out.println("5. Print All Employees");
            System.out.println("6. Exit");
            System.out.println("==========================================");
            System.out.print("Enter your choice (1-6): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter annual salary: ");
                    double annualSalary = scanner.nextDouble();
                    System.out.print("Enter hire date (MM/dd/yyyy): ");
                    String hireDateStr = scanner.next();
                    LocalDate hireDate = LocalDate.parse(hireDateStr, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                    scanner.nextLine(); // Consume newline character

                    Employee employee = new Employee(name, email, phoneNumber, annualSalary, hireDate);
                    hrms.addEmployee(employee);
                    break;
                case 2:
                    hrms.editEmployee();
                    break;
                case 3:
                    hrms.terminateEmployee();
                    break;
                case 4:
                    hrms.viewEmployeeInformation();
                    break;
                case 5:
                    hrms.printAllEmployees();
                    break;
                case 6:
                    System.out.println("Have a great day. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
