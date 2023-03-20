package Modal;

import java.util.Date;
import java.util.UUID;

public class Employees {
    private int employee_id;
    private String employee_code;
    private String employee_name;
    private Date date_of_birth;
    private String gender;
    private String address;
    private String phone;
    private String email;
    private int salary;
    private String department_id;
    private int namager_id;

    public Employees() {
    }

    public Employees(int employee_id, String employee_code, String employee_name, Date date_of_birth, String gender, String address, String phone, String email, int salary, String department_id, int namager_id) {
        this.employee_id = employee_id;
        this.employee_code = employee_code;
        this.employee_name = employee_name;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
        this.department_id = department_id;
        this.namager_id = namager_id;
    }

    public Employees(String employee_code, String employee_name, Date date_of_birth, String gender, String address, String phone, String email, int salary, String department_id, int namager_id) {
        this.employee_code = employee_code;
        this.employee_name = employee_name;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
        this.department_id = department_id;
        this.namager_id = namager_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_code() {
        return employee_code;
    }

    public void setEmployee_code(String employee_code) {
        this.employee_code = employee_code;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public int getNamager_id() {
        return namager_id;
    }

    public void setNamager_id(int namager_id) {
        this.namager_id = namager_id;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employee_id=" + employee_id +
                ", employee_code='" + employee_code + '\'' +
                ", employee_name='" + employee_name + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", department_id='" + department_id + '\'' +
                ", namager_id=" + namager_id +
                '}';
    }
}

