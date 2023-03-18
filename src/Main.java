import Service.DepartmentService;
import Service.LogInService;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LogInService logInService = new LogInService();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Log in");
            System.out.println("2. Exit");
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    if (logInService.checkLogin()) {
                        System.out.println("Log in successfully");
                    } else {
                        System.out.println("Log in failed");
                    }
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}