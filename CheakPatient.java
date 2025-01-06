import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CheakPatient {

    public void CheakPatient(){

        String url = "jdbc:mysql://localhost:3306/onlinehealthcaremanagementsystem";
        String DBusername = "root";
        String DBPassword = "rahman__12181";

        try (Connection connection=DriverManager.getConnection(url, DBusername, DBPassword)) {
            Scanner s=new Scanner(System.in);
            System.out.println("|----Welcome To Doctor Cabin-----|");
            System.out.println("Enter PatientID:");
            int patientID=s.nextInt();
            s.nextLine();
            System.out.println("Enter patient Name:");
            String PatientName=s.nextLine();
            System.out.println("Enter patient Contact Number:");
            String phonenumber = s.nextLine();
            System.out.println("Enter date:format(yyyy-mm-d)");
            String date=s.nextLine();
            System.out.println("Enter Patient Dieases:");
            String dieases=s.nextLine();
            System.out.println(" Enter Doctor Name:");
            String doctorname=s.nextLine();

            String query="INSERT INTO cheakpatient(patientID,PatientName,phonenumber,date,dieases,doctorname)VALUES(?,?,?,?,?,?)";
            try(PreparedStatement statement=connection.prepareStatement(query)){
                statement.setInt(1, patientID);
                statement.setString(2, PatientName);
                statement.setString(3, phonenumber);
                statement.setString(4, date);
                statement.setString(5, dieases);
                statement.setString(6, doctorname);
                
                int exicutequery=statement.executeUpdate();
                   System.out.println("Cheaked patient Successfully..!:"+exicutequery);
            }
        } catch (SQLException e) {
            if (e.getErrorCode()==1062) {
                System.out.println("Duplicate patient cant cheaked..");
            }
            
            e.getStackTrace();
        }
    }
}
