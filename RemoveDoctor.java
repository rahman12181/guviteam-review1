import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RemoveDoctor {

    public void removeDoctor() {
        String url = "jdbc:mysql://localhost:3306/onlinehealthcaremanagementsystem";
        String DBusername = "root";
        String DBPassword = "rahman__12181";

        try (Connection connection = DriverManager.getConnection(url, DBusername, DBPassword)) {
            Scanner scanner = new Scanner(System.in);

           
            System.out.println("Enter Doctor ID:");
            int doctorID = scanner.nextInt();
            scanner.nextLine(); 
            System.out.println("Enter Doctor Name:");
            String doctorName = scanner.nextLine();

           
            String checkQuery = "SELECT * FROM Doctors WHERE doctorID = ? AND doctorname = ?";
            try (PreparedStatement checkStatement = connection.prepareStatement(checkQuery)) {
                checkStatement.setInt(1, doctorID);
                checkStatement.setString(2, doctorName);

                ResultSet resultSet = checkStatement.executeQuery();

                if (resultSet.next()) {
                   
                    String deleteQuery = "DELETE FROM Doctors WHERE doctorID = ? AND doctorname = ?";
                    try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
                        deleteStatement.setInt(1, doctorID);
                        deleteStatement.setString(2, doctorName);

                        int rowsDeleted = deleteStatement.executeUpdate();
                        if (rowsDeleted > 0) {
                            System.out.println("Doctor removed successfully.");
                        }
                    }
                } else {
                    System.out.println("Doctor not found. Please check the ID and Name.");
                }
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the database or executing queries.");
            e.printStackTrace();
        }
    }
}