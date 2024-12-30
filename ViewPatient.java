import java.util.ArrayList;
import java.util.List;

public class ViewPatient {

    public void viewPatients() {
        List<Patient> patients = getPatients();

        for (Patient patient : patients) {
            System.out.println("Patient ID: " + patient.getId());
            System.out.println("Name: " + patient.getName());
            System.out.println("Age: " + patient.getAge());
            System.out.println("Disease: " + patient.getDisease());
            System.out.println("---------------------------");
        }
    }

    private List<Patient> getPatients() {
        // This method should return a list of patients. 
        // For demonstration, we are creating a few patients manually.
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(1, "John Doe", 30, "Flu"));
        patients.add(new Patient(2, "Jane Smith", 25, "Cold"));
        patients.add(new Patient(3, "Mike Johnson", 40, "Diabetes"));
        return patients;
    }

    class Patient {
        private int id;
        private String name;
        private int age;
        private String disease;

        public Patient(int id, String name, int age, String disease) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.disease = disease;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getDisease() {
            return disease;
        }
    }
}