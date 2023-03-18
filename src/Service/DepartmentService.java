package Service;

import DAO.DepartmentDAO;
import Modal.Department;

import java.util.List;
import java.util.Scanner;

public class DepartmentService {
    public static  Scanner scanner = new Scanner(System.in);
    public DepartmentDAO departmentDAO;
    //TODO1: Create a method to get all departments
    public void getAllDepartments() {
        List<Department> departments = departmentDAO.getAllDepartment();
        if (departments.size()>0) {
            for (int i = 0; i < departments.size(); i++) {
                System.out.println(departments.get(i).toString());
            }
        } else {
            System.out.println("No department found");
        }
    }
    //TODO2: Create a method to get a department by id
    public void showDepartmentById() {
        System.out.println("Enter department id: ");
        Integer departmentId = Integer.parseInt(scanner.nextLine());
        Department department = departmentDAO.getDepartmentById(departmentId);
        if(department == null){
            System.out.println("Department not found");
        } else {
            System.out.println(department.toString());
        }
    }
    //TODO3: Create a method to update a department
    public void updateDepartment() {
        System.out.println("Enter department id: ");
        Integer departmentId = Integer.parseInt(scanner.nextLine());
        Department department = departmentDAO.getDepartmentById(departmentId);
        if(department == null){
            System.out.println("Department not found");
        } else {
            System.out.println("Enter department code: ");
            String departmentCode = scanner.nextLine();
            System.out.println("Enter department name: ");
            String departmentName = scanner.nextLine();
            department.setDepartment_code(departmentCode);
            department.setDepartment_name(departmentName);
            departmentDAO.updateDepartment(department);
            System.out.println("Update department successfully");
        }
    }

    //TODO4: Create a method to delete a department
    public void deleteDepartment() {
        System.out.println("Enter department id: ");
        Integer departmentId = Integer.parseInt(scanner.nextLine());
        Department department = departmentDAO.getDepartmentById(departmentId);
        if(department == null){
            System.out.println("Department not found");
        } else {
            departmentDAO.deleteDepartment(departmentId);
            System.out.println("Delete department successfully");
        }
    }
    //TODO5: Create a method to create a department
    public void createDepartment() {
        System.out.println("Enter department code: ");
        String departmentCode = scanner.nextLine();
        System.out.println("Enter department name: ");
        String departmentName = scanner.nextLine();
        Department department = new Department(departmentCode, departmentName);
        departmentDAO.insertDepartment(department);
        System.out.println("Create department successfully");
    }
}
