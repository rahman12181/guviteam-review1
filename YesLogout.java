import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class YesLogout {

    public void yesLogout() {

        String url = "jdbc:mysql://localhost:3306/onlinehealthcaremanagementsystem";
        String DBusername = "root";
        String DBPassword = "rahman__12181";

        try (Connection connection = DriverManager.getConnection(url, DBusername, DBPassword)) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Your Username for logging out:");
            String username = scanner.nextLine();

            // Check if the username exists
            String checkQuery = "SELECT * FROM signup WHERE Username=?";
            try (PreparedStatement checkStatement = connection.prepareStatement(checkQuery)) {
                checkStatement.setString(1, username);
                try (ResultSet resultSet = checkStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // If username exists, delete the user
                        String deleteQuery = "DELETE FROM signup WHERE Username=?";
                        try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
                            deleteStatement.setString(1, username);
                            int rowsDeleted = deleteStatement.executeUpdate();
                            if (rowsDeleted > 0) {
                                System.out.println("You logged out successfully!");
                            }
                        }
                    } else {
                        System.out.println("Incorrect username, please try again.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}