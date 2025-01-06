import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class VerifyAppointment {

    public void verifyAppointment() {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/onlinehealthcaremanagementsystem";
        String DBusername = "root";
        String DBPassword = "rahman__12181";

        try (Connection connection = DriverManager.getConnection(url, DBusername, DBPassword)) {
            Scanner scanner = new Scanner(System.in);

            // Taking input from user
            System.out.println("|--- Insert Verify Appointment ---|");
            System.out.print("Enter Verified Appointment ID: ");
            String verifiedAppointmentID = scanner.nextLine();
            System.out.print("Enter Book Appointment ID: ");
            String bookAppointmentID = scanner.nextLine();
            System.out.print("Enter Time (HH:MM:SS): ");
            String time = scanner.nextLine();
            System.out.print("Enter Status: ");
            String status = scanner.nextLine();

            // SQL query to insert data
            String query = "INSERT INTO verifyappointment (verifiedAppointmentID, bookAppointmentID, Time, status) VALUES (?, ?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                // Setting parameters
                statement.setString(1, verifiedAppointmentID);
                statement.setString(2, bookAppointmentID);
                statement.setString(3, time);
                statement.setString(4, status);

                // Execute the query
                int rowsInserted = statement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("Appointment verification added successfully!");
                } else {
                    System.out.println("Failed to add appointment verification. Please try again.");
                }
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while inserting the data.");
            e.printStackTrace();
        }
    }

}