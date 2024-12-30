import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddDoctor {

    // Inner class to represent a Doctor
    static class Doctor {
        String name;
        String specialization;
        String contactNumber;
        String email;
        int experience;

        // Constructor
        public Doctor(String name, String specialization, String contactNumber, String email, int experience) {
            this.name = name;
            this.specialization = specialization;
            this.contactNumber = contactNumber;
            this.email = email;
            this.experience = experience;
        }

        @Override
        public String toString() {
            return "Name: " + name + "\n" +
                   "Specialization: " + specialization + "\n" +
                   "Contact Number: " + contactNumber + "\n" +
                   "Email: " + email + "\n" +
                   "Experience: " + experience + " years";
        }
    }

    // List to store doctors
    private List<Doctor> doctors;

    // Constructor to initialize the list
    public AddDoctor() {
        doctors = new ArrayList<>();
    }

    // Method to add a new doctor using user input
    public void addDoctor() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Doctor's Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();

        System.out.print("Enter Contact Number: ");
        String contactNumber = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Years of Experience: ");
        int experience = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Adding doctor to the list
        Doctor newDoctor = new Doctor(name, specialization, contactNumber, email, experience);
        doctors.add(newDoctor);
        System.out.println("Doctor added successfully!");
    }

    // Method to view all doctors
    public void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
        } else {
            System.out.println("List of Doctors:");
            for (Doctor doctor : doctors) {
                System.out.println(doctor);
                System.out.println("--------------------------");
            }
        }
    }

    // Method to get the list of doctors (for external usage)
    public List<Doctor> getDoctors() {
        return doctors;
    }
}
