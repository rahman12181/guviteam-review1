import java.sql.*;
import java.util.Scanner;

public class UserAuthontication {

    public void UserAuthontication() {
        while (true) {
            Scanner s = new Scanner(System.in);
            System.out.println("Welcome To User Authentication Page");
            System.out.println("1. Login");
            System.out.println("2. SignUp");
            System.out.println("Enter Your Option Here:");
            int option = s.nextInt();
            s.nextLine(); 
            switch (option) {
                case 1:
                    System.out.println("|------Login------|");
                    Login login=new Login();
                    login.Login();
                    return;
                case 2:
                    System.out.println("|----SignUp----|");
                    SignUp signup=new SignUp();
                    signup.SignUp();
                    return;
                default:
                    System.out.println("Invalid option... Please try again.");
                    return;
            }
        }
    }

   

   
}
