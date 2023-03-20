package DAO;

import Database.Connect;
import Modal.Employees;

import java.sql.*;
import java.util.List;

public class EmployeeDAO {
    //Create method to get all employees
    public List<Employees> getAllEmployees() {
        List<Employees> employees = null;
        Connection conn = null;
        try {
            conn = Connect.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM employees";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Employees employee = new Employees();
                employee.setEmployee_code(rs.getString("employee_code"));
                employee.setEmployee_name(rs.getString("employee_name"));
                employee.setDate_of_birth(rs.getDate("date_of_birth"));
                employee.setGender(rs.getString("gender"));
                employee.setAddress(rs.getString("employee_address"));
                employee.setPhone(rs.getString("employee_phone"));
                employee.setEmail(rs.getString("employee_email"));
                employee.setSalary(rs.getInt("employee_salary"));
                employee.setDepartment_id(rs.getString("department_id"));
                employee.setNamager_id(rs.getInt("department_id"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }
    //Create method to get employee by id
    public Employees showEmployeeById(int id){
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM employees e WHERE e.employee_id = " + id;
            ResultSet rs = stmt.executeQuery(sql);
            Employees employee = null;
            while(rs.next()) {
                employee.setEmployee_code(rs.getString("employee_code"));
                employee.setEmployee_name(rs.getString("employee_name"));
                employee.setDate_of_birth(rs.getDate("date_of_birth"));
                employee.setGender(rs.getString("gender"));
                employee.setAddress(rs.getString("employee_address"));
                employee.setPhone(rs.getString("employee_phone"));
                employee.setEmail(rs.getString("employee_email"));
                employee.setSalary(rs.getInt("employee_salary"));
                employee.setDepartment_id(rs.getString("department_id"));
                employee.setNamager_id(rs.getInt("department_id"));
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
    public Employees insertEmployee(Employees employee){
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql = "INSERT INTO employee(employee_code,employee_name,date_of_birth,gender,address,phone,email,identity_number,salary,position_name,department_id,department_code,department_name,manager_id)\n" +
                    "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            prst=conn.prepareStatement(sql);
            prst.setString(1,employee.getEmployee_code());
            prst.setString(2,employee.getEmployee_name());
            prst.setDate(3, (Date) employee.getDate_of_birth());
            prst.setString(4,employee.getGender());
            prst.setString(5,employee.getAddress());
            prst.setString(6,employee.getPhone());
            prst.setString(7,employee.getEmail());
            prst.setInt(9,employee.getSalary());
            prst.setString(11,employee.getDepartment_id());
            prst.setInt(14,employee.getNamager_id());
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
    public Employees updateEmployee(int id, Employees employees){
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
    public Employees deleteEmployee(int id) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql = "DELETE FROM employees WHERE employee_id = ?";
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
}
