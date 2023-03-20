package Service.EmployeeService;

import DAO.EmployeeDAO.EmployeeDAO;
import Modal.Employees;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.spi.DateFormatProvider;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmployeeService {
    public static Scanner scanner = new Scanner(System.in);
    public EmployeeDAO employeeDAO;
    //TODO: Create a method to get all employees
    public void getAllEmployees() {
        List<Employees>  employees= employeeDAO.getAllEmployees();
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).toString());
        }
    }

    //TODO: Create a method to get an employee by id
    public void getEmployeeByID(){
        System.out.println("Enter employee id: ");
        Integer employeeId = Integer.parseInt(scanner.nextLine());
        Employees employees = employeeDAO.showEmployeeById(employeeId);
        if (employees == null) {
            System.out.println("Employee not found");
        }else {
            System.out.println(employees.toString());
        }
    }

    //TODO: Create a method to update an employee
    public void updateEmployee(){
        System.out.println("Enter employee id: ");
        Integer employeeId = Integer.parseInt(scanner.nextLine());
        Employees employees = employeeDAO.showEmployeeById(employeeId);
        if (employees == null) {
            System.out.println("Employee not found");
        }else {
            System.out.println("Enter employee name: ");
            String employeeName = scanner.nextLine();
            System.out.println("Enter employee email: ");
            String employeeEmail = scanner.nextLine();
            System.out.println("Enter employee phone: ");
            String employeePhone = scanner.nextLine();
            System.out.println("Enter employee address: ");
            String employeeAddress = scanner.nextLine();
            System.out.println("Enter employee salary: ");
            Integer employeeSalary = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter employee department id: ");
            Integer employeeDepartmentId = Integer.parseInt(scanner.nextLine());
            employees.setEmployee_name(employeeName);
            employees.setEmail(employeeEmail);
            employees.setPhone(employeePhone);
            employees.setAddress(employeeAddress);
            employees.setSalary(employeeSalary);
//            employeeDAO.updateEmployee(employees);
            System.out.println("Update employee successfully");
        }
    }
    //TODO: Create a method to delete an employee
    public void deleteEmployee(){
        System.out.println("Enter employee id: ");
        Integer employeeId = Integer.parseInt(scanner.nextLine());
        Employees employees = employeeDAO.showEmployeeById(employeeId);
        if (employees == null) {
            System.out.println("Employee not found");
        }else {
            employeeDAO.deleteEmployee(employeeId);
            System.out.println("Delete employee successfully");
        }
    }
    //TODO: Create a method create an employee
    public void createEmployee() throws ParseException {
        System.out.println("Enter employee code: ");
        String employeeCode = scanner.nextLine();
        System.out.println("Enter employee name: ");
        String employeeName = scanner.nextLine();
        System.out.println("Enter employee date of bỉth: ");
        String employeeDateOfBirth = scanner.nextLine();
        System.out.println("Enter employee gender: ");
        String employeeGender = scanner.nextLine();
        System.out.println("Enter employee address: ");
        String employeeAddress = scanner.nextLine();
        System.out.println("Enter employee phone: ");
        String employeePhone = scanner.nextLine();
        System.out.println("Enter employee email: ");
        String employeeEmail = scanner.nextLine();
        System.out.println("Enter employee salary: ");
        Integer employeeSalary = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter employee department id: ");
        Integer employeeDepartmentId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter employee manager ID: ");
        Integer employeeManagerId = Integer.parseInt(scanner.nextLine());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(employeeDateOfBirth);

        Employees employees = new Employees(employeeCode,employeeName,date,employeeGender,employeeAddress,employeePhone,employeeEmail,employeeSalary,employeeDepartmentId,employeeManagerId);
        employeeDAO.insertEmployee(employees);
        System.out.println("Create employee successfully");
    }
}
