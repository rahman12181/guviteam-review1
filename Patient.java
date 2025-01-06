import java.util.Scanner;

public class Patient {

    public void patientMenu() {
        while(true){
        System.out.println("Welcome Patient");
        System.out.println("1. Book Appointment");
        System.out.println("2. View Appointments");
        System.out.println("3. View Prescriptions");
        System.out.println("4. dashboard");
        System.out.println("5. Logout");
        System.out.println("Enter your choice:");
        
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        
        switch (choice) {
            case 1:
            BookAppointment appointment=new  BookAppointment();
            appointment.bookAppointment();
                break;
            case 2:
            ViewAppoinment vappoinment=new ViewAppoinment();
              vappoinment.viewAppointments();
                break;
            case 3:
            ViewPrescriptions priscrption=new ViewPrescriptions();
               priscrption.viewPrescriptions();
                break;
                case 4:
                System.out.println("welcome dashboard");
                return;
            case 5:
                System.out.println("Logging out...");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
    }

    /*private void viewAppointments() {
        // Code to view appointments
        System.out.println("Viewing all appointments...");
    }

    private void bookAppointment() {
        // Code to book an appointment
        System.out.println("Booking a new appointment...");
    }

    private void viewPrescriptions() {
        // Code to view prescriptions
        System.out.println("Viewing all prescriptions...");
    }*/
}