import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SeeBookedAppointment {

    public void seeBookedAppointment(){
        String url = "jdbc:mysql://localhost:3306/onlinehealthcaremanagementsystem";
        String DBusername = "root";
        String DBPassword = "rahman__12181";

        try (Connection connection = DriverManager.getConnection(url, DBusername, DBPassword)) {
            System.out.println("|---- Retrieve Appointments ----|");

            String query = "SELECT * FROM BookAppointments";  // Query to select all records from the table

            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                System.out.println("|--- Appointments List ---|");
                while (resultSet.next()) {
                    String appointmentID = resultSet.getString("bookAppointmentID");
                    String patientName = resultSet.getString("patientName");
                    String doctorName = resultSet.getString("doctorName");
                    String date = resultSet.getString("date");
                    String reason = resultSet.getString("reason");
                    String status = resultSet.getString("status");

                    // Displaying the retrieved data
                    System.out.println("Appointment ID: " + appointmentID);
                    System.out.println("Patient Name: " + patientName);
                    System.out.println("Doctor Name: " + doctorName);
                    System.out.println("Date: " + date);
                    System.out.println("Reason: " + reason);
                    System.out.println("Status: " + status);
                    System.out.println("|-------------------------------|");
                }
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while retrieving appointments.");
            e.printStackTrace();
        }
    }
}
