import java.util.Scanner;
public class OnlineHealthcareManagementSystem {

public static void main(String[] args) {
    while(true){
    System.out.println("Welcome to Online Healthcare Management System");
    System.out.println("Please select the option from below:");
    System.out.println("1. Patient");
    System.out.println("2. Doctor");
    System.out.println("3. Admin");
    System.out.println("4. Exit");
    System.out.println("Enter your choice:");
    Scanner sc = new Scanner(System.in);
    int choice = sc.nextInt();
    switch (choice) {
        case 1:
            Patient patient = new Patient();
            patient.patientMenu();
            break;
        case 2:
            Doctor doctor = new Doctor();
            doctor.doctorMenu();
            break;
        case 3:
            Admin admin = new Admin();
            admin.adminMenu();
            break;
        case 4:
            System.out.println("Thank you for using Online Healthcare Management System");
            break;
        default:
            System.out.println("Invalid choice");
            break;
    }
    
}
    
}

}