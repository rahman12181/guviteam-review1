public class Prescription {
    private String patientName;
    private String doctorName;
    private String medication;
    private String dosage;
    private String instructions;
    private String frequency; // Added to store frequency of medication

    // Updated constructor to include 'frequency'
    public Prescription(String patientName, String doctorName, String medication, String dosage, String instructions, String frequency) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.medication = medication;
        this.dosage = dosage;
        this.instructions = instructions;
        this.frequency = frequency;
    }

    // Getter and setter methods
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    // Added save method
    public void save() {
        System.out.println("Prescription saved successfully!");
    }

    // Updated toString method to include 'frequency'
    @Override
    public String toString() {
        return "Prescription{" +
                "patientName='" + patientName + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", medication='" + medication + '\'' +
                ", dosage='" + dosage + '\'' +
                ", instructions='" + instructions + '\'' +
                ", frequency='" + frequency + '\'' +
                '}';
    }
}
