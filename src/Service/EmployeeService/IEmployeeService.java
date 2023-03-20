package Service.EmployeeService;

import java.text.ParseException;

public interface IEmployeeService {
    void getAllEmployees();
    void getEmployeeByID();
    void updateEmployee();
    void deleteEmployee();
    void createEmployee() throws ParseException;
    void searchEmployee();
}
