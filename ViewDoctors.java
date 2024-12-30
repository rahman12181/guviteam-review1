public class ViewDoctors {

    // Class to hold doctor information
    static class Doctor {
        String name;
        String specialization;
        String contactNumber;
        String email;
        int experience; // in years

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

    public void viewDoctor() {
        // Array of doctors with detailed information
        Doctor[] doctors = {
            new Doctor("Dr. Smith", "Cardiologist", "123-456-7890", "dr.smith@hospital.com", 15),
            new Doctor("Dr. Johnson", "Neurologist", "987-654-3210", "dr.johnson@hospital.com", 10),
            new Doctor("Dr. Williams", "Pediatrician", "456-789-1230", "dr.williams@hospital.com", 8)
        };

        System.out.println("List of Doctors with Detailed Information:");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
            System.out.println("--------------------------");
        }
    }

    public static void main(String[] args) {
        ViewDoctors viewDoctors = new ViewDoctors();
        viewDoctors.viewDoctor();
    }
}
