package Database;

import java.sql.Connection;
import java.sql.SQLException;

public class Connect {
    private static Connect connect = null;
    private static String url = Config.Config.DB_URL;
    private static String user = Config.Config.DB_USER;
    private static String password = Config.Config.PASSWORD;
    private Connect() {}
    public  static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = java.sql.DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Driver not found", e);
        } catch (ClassNotFoundException e){
            throw new RuntimeException("Driver not found", e);
        }
        return connection;
    }
    public static Connect getInstance() {
        return connect == null ? new Connect() : connect;
    }
}
