import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewPatient {

    public void viewAllPatients() {
        String url = "jdbc:mysql://localhost:3306/onlinehealthcaremanagementsystem";
        String DBusername = "root";
        String DBPassword = "rahman__12181";

        try (Connection connection = DriverManager.getConnection(url, DBusername, DBPassword)) {
            System.out.println("|---- Retrieve All Patient Details ----|");

            String query = "SELECT * FROM cheakpatient";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                ResultSet resultSet = statement.executeQuery();

                boolean recordsFound = false;
                while (resultSet.next()) {
                    recordsFound = true;
                    System.out.println("|---*----*-----*-----*-----*-----*-----*------*-----*----*---|");
                    System.out.println("Patient ID: " + resultSet.getInt("patientID"));
                    System.out.println("Patient Name: " + resultSet.getString("PatientName"));
                    System.out.println("Phone Number: " + resultSet.getString("phonenumber"));
                    System.out.println("Date: " + resultSet.getString("date"));
                    System.out.println("Disease: " + resultSet.getString("dieases"));
                    System.out.println("Doctor Name: " + resultSet.getString("doctorname"));
                    System.out.println("|---*----*-----*-----*-----*-----*-----*------*-----*----*---|");
                }

                if (!recordsFound) {
                    System.out.println("No patient records found in the database.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
