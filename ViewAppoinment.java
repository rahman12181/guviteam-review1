
        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        
        public class ViewAppoinment {
        
            public void viewAppointments() {
                String url = "jdbc:mysql://localhost:3306/onlinehealthcaremanagementsystem";
                String DBusername = "root";
                String DBPassword = "rahman__12181";
        
                try (Connection connection = DriverManager.getConnection(url, DBusername, DBPassword)) {
                    String query = "SELECT BookAppointments.bookAppointmentID, \r\n" + //
                                                "       BookAppointments.patientName, \r\n" + //
                                                "       BookAppointments.doctorName, \r\n" + //
                                                "       BookAppointments.date, \r\n" + //
                                                "       BookAppointments.reason, \r\n" + //
                                                "       verifyappointment.Time, \r\n" + //
                                                "       verifyappointment.status \r\n" + //
                                                "FROM BookAppointments \r\n" + //
                                                "LEFT JOIN verifyappointment ON BookAppointments.bookAppointmentID = verifyappointment.bookAppointmentID;\r\n" + //
                                                "";
        
                    try (PreparedStatement statement = connection.prepareStatement(query);
                         ResultSet resultSet = statement.executeQuery()) {
        
                        System.out.println("|--- Joined Appointments ---|");
                        while (resultSet.next()) {
                            String bookAppointmentID = resultSet.getString("bookAppointmentID");
                            String patientName = resultSet.getString("patientName");
                            String doctorName = resultSet.getString("doctorName");
                            String date = resultSet.getString("date");
                            String reason = resultSet.getString("reason");
                            String time = resultSet.getString("Time");
                            String status = resultSet.getString("status");
        
                            // Displaying the result
                            System.out.println("Book Appointment ID: " + bookAppointmentID);
                            System.out.println("Patient Name: " + patientName);
                            System.out.println("Doctor Name: " + doctorName);
                            System.out.println("Date: " + date);
                            System.out.println("Reason: " + reason);
                            System.out.println("Time: " + time);
                            System.out.println("Status: " + status);
                            System.out.println("-------------------------------");
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("An error occurred while retrieving data.");
                    e.printStackTrace();
                }
            }
    }

