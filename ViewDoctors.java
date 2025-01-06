import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewDoctors {

    public void viewAllDoctors() {
        String url = "jdbc:mysql://localhost:3306/onlinehealthcaremanagementsystem";
        String DBusername = "root";
        String DBPassword = "rahman__12181";

        try (Connection connection = DriverManager.getConnection(url, DBusername, DBPassword)) {
            System.out.println("|---- Retrieve All Doctor Details ----|");

            String query = "SELECT * FROM Doctors";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                ResultSet resultSet = statement.executeQuery();

                boolean recordsFound = false;
                while (resultSet.next()) {
                    recordsFound = true;
                    System.out.println("--------------------------------------------------");
                    System.out.println("Doctor ID: " + resultSet.getInt("doctorID"));
                    System.out.println("Doctor Name: " + resultSet.getString("doctorname"));
                    System.out.println("Specialization: " + resultSet.getString("specialization"));
                    System.out.println("Qualification: " + resultSet.getString("qualification"));
                    System.out.println("Experience: " + resultSet.getString("experiance"));
                }

                if (!recordsFound) {
                    System.out.println("No doctor records found in the database.");
                }
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the database or retrieving data.");
            e.printStackTrace();
        }
    }
}
