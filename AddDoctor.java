import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddDoctor {

    public void addDoctor(){

        String url = "jdbc:mysql://localhost:3306/onlinehealthcaremanagementsystem";
        String DBusername = "root";
        String DBPassword = "rahman__12181";

        try (Connection connection=DriverManager.getConnection(url, DBusername, DBPassword)) {
            Scanner s=new Scanner(System.in);
            System.out.println("Enter DoctorID:");
            int doctorID=s.nextInt();
            s.nextLine();
            System.out.println("Enter Doctor Name");
            String doctorname=s.nextLine();
            System.out.println("Enter Doctor specialization:");
            String specialization=s.nextLine();
            System.out.println("Enter doctor Qualification:");
            String qualification=s.nextLine();
            System.out.println("Enter year of Experiance");
            String experiance=s.nextLine();

            String query="INSERT INTO Doctors(doctorID,doctorname,specialization,qualification,experiance)VALUES(?,?,?,?,?)";
            try(PreparedStatement statement=connection.prepareStatement(query)){
                    statement.setInt(1, doctorID);
                    statement.setString(2, doctorname);
                    statement.setString(3, specialization);
                    statement.setString(4, qualification);
                    statement.setString(5, experiance);


                    int rowinserted=statement.executeUpdate();
                    System.out.println("Doctor Added Successfully..."+rowinserted);
                    System.out.println("|-----INSERTED dOCTOR DETAIL-----|");
                    System.out.println("doctorID:"+doctorID);
                    System.out.println("doctorname:"+doctorname);
                    System.out.println("specialization:"+specialization);
                    System.out.println("qualification:"+qualification);
                    System.out.println("experiance:"+experiance);
                    System.out.println("|------------------------|");
                    
            }
        } catch (SQLException e) {
            
            if (e.getErrorCode()==1062) {
                System.out.println("Dupticate data cant insert!!!");
            }
            else{
                e.getStackTrace();
            }
        }
    }
}