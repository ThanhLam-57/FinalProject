package Modal;

import java.util.Date;

public class Employees {
    private int employee_id;
    private String employee_code;
    private String employee_name;
    private Date date_of_birth;
    private String gender;
    private String address;
    private String phone;
    private String email;
    private String identity_number;
    private int salary;
    private String position_name;
    private String department_id;
    private String department_code;
    private String department_name;

    public Employees() {
    }

    public Employees(int employee_id, String employee_code, String employee_name, Date date_of_birth, String gender, String address, String phone, String email, String identity_number, int salary, String position_name, String department_id, String department_code, String department_name) {
        this.employee_id = employee_id;
        this.employee_code = employee_code;
        this.employee_name = employee_name;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.identity_number = identity_number;
        this.salary = salary;
        this.position_name = position_name;
        this.department_id = department_id;
        this.department_code = department_code;
        this.department_name = department_name;
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

    public String getIdentity_number() {
        return identity_number;
    }

    public void setIdentity_number(String identity_number) {
        this.identity_number = identity_number;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_code() {
        return department_code;
    }

    public void setDepartment_code(String department_code) {
        this.department_code = department_code;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
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
                ", identity_number='" + identity_number + '\'' +
                ", salary=" + salary +
                ", position_name='" + position_name + '\'' +
                ", department_id='" + department_id + '\'' +
                ", department_code='" + department_code + '\'' +
                ", department_name='" + department_name + '\'' +
                '}';
    }
}

