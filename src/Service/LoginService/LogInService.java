package Service.LoginService;

import DAO.LogInDAO.LogInDAO;

import java.util.Scanner;

public class LogInService {
    public static Scanner scanner = new Scanner(System.in);
    public LogInDAO logInDAO;
    public boolean checkLogin() {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        if (logInDAO.checkLoginDAO(username, password)){
            return true;
        } else {
            return false;
        }
    }
}
