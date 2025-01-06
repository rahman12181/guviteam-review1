import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
  
    public void Login() {

        String url = "jdbc:mysql://localhost:3306/onlinehealthcaremanagementsystem";
        String DBusername = "root";
        String DBPassword = "rahman__12181";

        try (Connection connection = DriverManager.getConnection(url, DBusername, DBPassword)) {

            Scanner s = new Scanner(System.in);

            System.out.println("Enter Username:");
            String username = s.nextLine();
            System.out.println("Enter Password:");
            String password = s.nextLine();

            String query = "SELECT * FROM SignUp WHERE Username = ? AND EmailOrPassword = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);
                statement.setString(2, password);

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    System.out.println("Login successful! Welcome " + resultSet.getString("Name"));
                } else {
                    System.out.println("Invalid username or password. User not found!");
                    Login login=new Login();
                    login.Login();
                }
                
            }

        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                System.out.println("Login failed... User already exists.");
            }
            e.printStackTrace();
        }
    }
}
