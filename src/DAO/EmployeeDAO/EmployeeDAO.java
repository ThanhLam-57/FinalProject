package DAO.EmployeeDAO;

import Database.Connect;
import Modal.Employees;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    //Create method to get all employees
    //Done
    public static List<Employees> getAllEmployees() {
        List<Employees> employees = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Connect.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM employee";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Employees employee = new Employees();
                employee.setEmployee_code(rs.getString("employee_code"));
                employee.setEmployee_name(rs.getString("employee_name"));
                employee.setDate_of_birth(rs.getDate("date_of_birth"));
                employee.setGender(rs.getString("gender"));
                employee.setAddress(rs.getString("address"));
                employee.setPhone(rs.getString("phone"));
                employee.setEmail(rs.getString("email"));
                employee.setSalary(rs.getInt("salary"));
                employee.setDepartment_id(rs.getInt("department_id"));
                employee.setNamager_id(rs.getInt("manager_id"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    //Create method to get employee by id
    //Done
    public static Employees showEmployeeById(int id){
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM employee e WHERE e.employee_id = " + id;
            ResultSet rs = stmt.executeQuery(sql);
            Employees employee = new Employees();
            while(rs.next()) {
                employee.setEmployee_code(rs.getString("employee_code"));
                employee.setEmployee_name(rs.getString("employee_name"));
                employee.setDate_of_birth(rs.getDate("date_of_birth"));
                employee.setGender(rs.getString("gender"));
                employee.setAddress(rs.getString("address"));
                employee.setPhone(rs.getString("phone"));
                employee.setEmail(rs.getString("email"));
                employee.setSalary(rs.getInt("salary"));
                employee.setDepartment_id(rs.getInt("department_id"));
                employee.setNamager_id(rs.getInt("manager_id"));
            }
            return employee;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //Create method to add new employee
    //Done
    public static Employees insertEmployee(Employees employee){
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql = "INSERT INTO employee(employee_code,employee_name,date_of_birth,gender,address,phone,email,salary,department_id,manager_id)\n" +
                    "VALUES(?,?,?,?,?,?,?,?,?,?);";
            prst=conn.prepareStatement(sql);
            prst.setString(1,employee.getEmployee_code());
            prst.setString(2,employee.getEmployee_name());

            java.sql.Date sqlDate = new java.sql.Date(employee.getDate_of_birth().getTime());
            prst.setDate(3, sqlDate);
            prst.setString(4,employee.getGender());
            prst.setString(5,employee.getAddress());
            prst.setString(6,employee.getPhone());
            prst.setString(7,employee.getEmail());
            prst.setInt(8,employee.getSalary());
            prst.setInt(9,employee.getDepartment_id());
            prst.setInt(10,employee.getNamager_id());
            prst.executeUpdate();
            return null;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            if(prst != null) {
                try {
                    prst.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    //Create method to update employee
    public static Employees updateEmployee(int id, Employees employees){
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = Connect.getInstance().getConnection();

            prst.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            if(prst != null) {
                try {
                    prst.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return employees;
    }

    //Create method to delete employee
    public static Employees deleteEmployee(int id) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql = "DELETE FROM employee WHERE employee_id = ?";
            prst = conn.prepareStatement(sql);
            prst.setInt(1, id);
            prst.executeUpdate();
            return null;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            if (prst != null) {
                try {
                    prst.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    //Create method to search employee by name, code, phone, email
    public static List<Employees> searchEmployee(String keyword){
        List<Employees> employees = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Connect.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM employee WHERE employee_code LIKE '%"+keyword+"%' OR employee_name LIKE '%"+keyword+"%' OR phone LIKE '%"+keyword+"%' OR email LIKE '%"+keyword+"%';";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Employees employee = new Employees();
                employee.setEmployee_code(rs.getString("employee_code"));
                employee.setEmployee_name(rs.getString("employee_name"));
                employee.setDate_of_birth(rs.getDate("date_of_birth"));
                employee.setGender(rs.getString("gender"));
                employee.setAddress(rs.getString("address"));
                employee.setPhone(rs.getString("phone"));
                employee.setEmail(rs.getString("email"));
                employee.setSalary(rs.getInt("salary"));
                employee.setDepartment_id(rs.getInt("department_id"));
                employee.setNamager_id(rs.getInt("manager_id"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }
}
