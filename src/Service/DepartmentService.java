package Service;

import Database.Connect;
import Modal.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentService {
    public void insertDepartment(Department department){
        Connection conn= null;
        PreparedStatement prst = null;
        try {
            conn = Connect.getConnection();
            String sql = "INSERT INTO department(department_code, department_name) VALUES (?, ?)";
            prst = conn.prepareStatement(sql);
            prst.setString(1, department.getDepartment_code());
            prst.setString(2, department.getDepartment_name());
            prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (prst != null) {
                    prst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public List<Department> getAllDepartment(){
        List<Department> departments = new ArrayList<>();
        Connection conn= null;
        PreparedStatement prst = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql = "SELECT * FROM department";
            prst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = prst.executeQuery();
            while (rs.next()){
                Department department = new Department();
                department.setDepartment_id(rs.getInt("department_id"));
                department.setDepartment_code(rs.getString("department_code"));
                department.setDepartment_name(rs.getString("department_name"));
                departments.add(department);
            }
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        } finally {
            try {
                if (prst != null) {
                    prst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return departments;
    }
    public Department updateDepartment(Department department){
        Connection conn= null;
        PreparedStatement prst = null;
        try {
            conn = Connect.getConnection();
            String sql = "UPDATE department SET department_code = ?, department_name = ? WHERE department_id = ?";
            prst = conn.prepareStatement(sql);
            prst.setString(1, department.getDepartment_code());
            prst.setString(2, department.getDepartment_name());
            prst.setInt(3, department.getDepartment_id());
            prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (prst != null) {
                    prst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return department;
    }
    public void deleteDepartment(int department_id){
        Connection conn= null;
        PreparedStatement prst = null;
        try {
            conn = Connect.getConnection();
            String sql = "DELETE FROM department WHERE department_id = ?";
            prst = conn.prepareStatement(sql);
            prst.setInt(1, department_id);
            prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (prst != null) {
                    prst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
