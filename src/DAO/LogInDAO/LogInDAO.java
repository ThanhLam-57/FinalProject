package DAO.LogInDAO;

import Database.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LogInDAO implements ILogInDAO {
    public static boolean checkLoginDAO(String username, String password) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM log_in li WHERE li.user_name ='"+username+"' AND li.password = '"+password+"';";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
