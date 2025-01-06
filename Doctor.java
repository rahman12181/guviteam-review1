import java.util.Scanner;



public class Doctor {

    public void doctorMenu() {
        while (true) {
            
        
        System.out.println("Welcome Doctor");
        System.out.println("1.SeeBookedAppointment");
        System.out.println("2. Verify Appointments");
        System.out.println("3. Add Prescription");
        System.out.println("4. Cheak Patients");
        System.out.println("5. dashboard");
        System.out.println("6. Logout");
        System.out.println("Enter your choice:");
        
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        
        switch (choice) {
            case 1:
             SeeBookedAppointment bookedAppointment=new SeeBookedAppointment();
             bookedAppointment.seeBookedAppointment();
               break;
            case 2:
            VerifyAppointment verifyAppoinment = new VerifyAppointment();
            verifyAppoinment.verifyAppointment();
            
                break;
            case 3:
            AddPrescription addPrescription = new AddPrescription();
                addPrescription.addPrescription();
                break;
            case 4:
              CheakPatient cheakPatient=new CheakPatient();
              cheakPatient.CheakPatient();
                break;
            case 5:
            System.out.println("welcome dashboard");
               return;    
            case 6:
                System.out.println("Logging out...");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    
    }
    }
    /*  class AddAppoinment {
        public void addAppoinment() {
            // Code to add an appointment
            System.out.println("Adding a new appointment...");
        }
    }

    private void addPrescription() {
        // Code to add a prescription
        System.out.println("Adding a new prescription...");
    }

    private void viewPatients() {
        // Code to view patients
        System.out.println("Viewing all patients...");
    }*/
}