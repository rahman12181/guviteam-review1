import java.util.Scanner;
public class Admin {
    
    public void adminMenu() {
        Scanner s=new Scanner(System.in);
        System.out.println("Only Admin Can Access this Pannel");
        String adminpassword="rahman__12181";
        System.out.println("Enter Admin Password");
        String password=s.nextLine();

          if (adminpassword.equals(password)) {    
        while (true) {  
        
            System.out.println("|****Welcome Admin****|");
            System.out.println("1. View Patients");
            System.out.println("2. Add Doctor");
            System.out.println("3. View Doctors");
            System.out.println("4. Remove Doctor");
            System.out.println("5. dashboard");
           // System.out.println("6. Logout");
            System.out.println("Enter your choice:");
            
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                ViewPatient viewPatient = new ViewPatient();
                viewPatient.viewAllPatients();
                    break;
                case 2:
                AddDoctor adddoctor = new AddDoctor();
                adddoctor.addDoctor();
                    break;
                case 3:
               
                ViewDoctors viewDoctor = new ViewDoctors();
                    viewDoctor.viewAllDoctors();
                    break;
                case 4:
                RemoveDoctor removeDoctor = new RemoveDoctor();
                removeDoctor.removeDoctor();
                    
                    break;
                case 5:
                    System.out.println(" welcome dashboard");
                    return;
                
                /*case 6:
                   LogOut logout= new LogOut();
                    logout.logOutUser();
                    System.out.println("Logging out...");
                    break;*/
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
          }
          else if (!adminpassword.equals(password)) {
              System.out.println("Incorrect Password"+"\nTry again");
              
          }
      
    }
    

   /*  private void viewPatients() {
        // Code to view patients
        System.out.println("Viewing all patients...");
    }

    private void viewDoctors() {
        // Code to view doctors
        System.out.println("Viewing all doctors...");
    }

    private void addDoctor() {
        // Code to add a doctor
        System.out.println("Adding a new doctor...");
    }

    private void removeDoctor() {
        // Code to remove a doctor
        System.out.println("Removing a doctor...");
    }*/
}