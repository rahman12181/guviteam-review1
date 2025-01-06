import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ViewPrescriptions {

    public void viewPrescriptions() {
        String url = "jdbc:mysql://localhost:3306/onlinehealthcaremanagementsystem";
        String DBusername = "root";
        String DBPassword = "rahman__12181";

        try (Connection connection = DriverManager.getConnection(url, DBusername, DBPassword)) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter patientID to View Prescription:");
            int patientID = scanner.nextInt();

            String query = "SELECT cheakpatient.patientID,cheakpatient.PatientName, prescription.prescriptionID, prescription.prescriptionDetails, prescription.date, prescription.phonenumber, prescription.dieases, prescription.doctorname " +
                           "FROM prescription  " +
                           "INNER JOIN cheakpatient  ON prescription.patientID = cheakpatient.patientID " +
                           "WHERE prescription.patientID = ?";
            
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, patientID);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    String prescriptionID = resultSet.getString("prescriptionID");
                    int pID = resultSet.getInt("patientID");
                    String patientName = resultSet.getString("PatientName");
                    String prescriptionDetails = resultSet.getString("prescriptionDetails");
                    String date = resultSet.getString("date");
                    String phonenumber = resultSet.getString("phonenumber");
                    String dieases = resultSet.getString("dieases");
                    String doctorname = resultSet.getString("doctorname");

                    System.out.println("|*********HEALTHCARE PRESCRIPTION********|");
                    System.out.println("-*--*--*--*--*--*--*--*--*--*--*---*---*---*-");
                    System.out.println("Prescription ID: " + prescriptionID);
                    System.out.println("Patient ID: " + pID);
                    System.out.println("Patient Name: " + patientName);
                    System.out.println("Prescription Details: " + prescriptionDetails);
                    System.out.println("Date: " + date);
                    System.out.println("Phone Number: " + phonenumber);
                    System.out.println("Diseases: " + dieases);
                    System.out.println("Doctor Name: " + doctorname);
                    System.out.println("-*--*--*--*--*--*--*--*--*--*--*---*---*---*-");

                } else {
                    System.out.println("No prescriptions found for Patient ID: " + patientID);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
