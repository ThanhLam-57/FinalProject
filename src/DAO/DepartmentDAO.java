package DAO;

import Database.Connect;
import Modal.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
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
    public Department getDepartmentById(int department_id){
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM scoremanagement s WHERE s.stdcode =" + department_id;
            ResultSet rs = stmt.executeQuery(sql);
            Department d = null;
            while(rs.next()) {
                d = new Department();
                d.setDepartment_id(rs.getInt("department_id"));
                d.setDepartment_code(rs.getString("department_code"));
                d.setDepartment_name(rs.getString("department_name"));
                d = new Department(rs.getInt("department_id"), rs.getString("department_code"), rs.getString("department_name"));
            }
            return d;
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
