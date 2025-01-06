import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BookAppointment {

    public void bookAppointment() {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/onlinehealthcaremanagementsystem";
        String DBusername = "root";
        String DBPassword = "rahman__12181";

        Scanner scanner = new Scanner(System.in);

        try (Connection connection = DriverManager.getConnection(url, DBusername, DBPassword)) {
            System.out.println("|---- Book Appointment ----|");

            // Taking input from the user
            System.out.print("Enter Appointment ID: ");
            String appointmentID = scanner.nextLine(); // `varchar` type for the primary key
            
            System.out.print("Enter Patient Name: ");
            String patientName = scanner.nextLine();
            
            System.out.print("Enter Doctor Name: ");
            String doctorName = scanner.nextLine();
            
            System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
            String date = scanner.nextLine();

            System.out.print("Enter Reason for Appointment: ");
            String reason = scanner.nextLine();

            String query = "INSERT INTO BookAppointments (bookAppointmentID, patientName, doctorName, date, reason, status) VALUES (?, ?, ?, ?, ?, 'Pending')";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, appointmentID);      // Set appointment ID
                statement.setString(2, patientName);       // Set patient name
                statement.setString(3, doctorName);        // Set doctor name
                statement.setString(4, date);              // Set appointment date
                statement.setString(5, reason);            // Set reason
                
                int rowsInserted = statement.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("Appointment booked successfully!");
                    System.out.println("|--- Appointment Details ---|");
                    System.out.println("Appointment ID: " + appointmentID);
                    System.out.println("Patient Name: " + patientName);
                    System.out.println("Doctor Name: " + doctorName);
                    System.out.println("Date: " + date);
                    System.out.println("Reason: " + reason);
                    System.out.println("Status: Pending");
                } else {
                    System.out.println("Failed to book the appointment. Please try again.");
                }
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while booking the appointment.");
            e.printStackTrace();
        }
    }
}
