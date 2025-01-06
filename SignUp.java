import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SignUp {
  
     public void SignUp() {
        String url = "jdbc:mysql://localhost:3306/onlinehealthcaremanagementsystem";
        String DBusername = "root";
        String DBPassword = "rahman__12181";

        try (Connection connection = DriverManager.getConnection(url, DBusername, DBPassword)) {

            Scanner s = new Scanner(System.in);
            System.out.println("Enter Your Name:");
            String name = s.nextLine();
            System.out.println("Enter Your Username:");
            String username = s.nextLine();
            System.out.println("Enter Your Email/Password:");
            String emailOrPassword = s.nextLine();

            String query = "INSERT INTO SignUp(name, username, emailOrPassword) VALUES (?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, name);
                statement.setString(2, username);
                statement.setString(3, emailOrPassword);

                int queryExecute = statement.executeUpdate();
                System.out.println("SignUp successful! Rows affected: " + queryExecute);
            }
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                System.out.println("Duplicate Username found. Please enter another username.");
            }
            e.printStackTrace();
        }
    }
}
