
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.SQLException;
    
    public class AddPrescription {
    
        public void addPrescription() {
           
            String url = "jdbc:mysql://localhost:3306/onlinehealthcaremanagementsystem";
            String DBusername = "root";
            String DBPassword = "rahman__12181";
    
            try (Connection connection = DriverManager.getConnection(url, DBusername, DBPassword)) {
                String query = "INSERT INTO Prescription (prescriptionID, patientID, prescriptionDetails, date, phonenumber, dieases, doctorname)\r\n" + //
                                        "SELECT CONCAT('PR', patientID), patientID, NULL, CURRENT_DATE, phonenumber, dieases, doctorname\r\n" + //
                                        "FROM CheakPatient;\r\n" + //
                                        "";
    
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    int rowsInserted = statement.executeUpdate();
                    System.out.println(rowsInserted + "  Prescription Added Succesfully...");
                }
    
            } catch (SQLException e) {
                System.out.println("An error occurred while copying data.");
                e.printStackTrace();
            }
        }
    }