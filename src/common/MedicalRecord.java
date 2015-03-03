package common;

public class MedicalRecord {
    private String doctor;
    private String nurse;
    private int division;
    private String disease;
    private String patientName;
    private String patientID;

    public MedicalRecord(String doctor, String nurse, int division, String disease, String patientName, String patientID){
        this.doctor = doctor;
        this.nurse = nurse;
        this.division = division;
        this.disease = disease;
        this.patientName = patientName;
        this.patientID = patientID;
    }


    /**
     * Returns a string of all the info in the medical record.
     *
     * @return String of the medical record
     */
    public String toString(){
        return "Doctor: " + doctor + " Division: " + division + " Nurse: " + nurse + " Disease: " + disease;
    }

    /**
     * Returns the division associated with the medical record.
     * @return The division
     */
    public int getDivision(){
        return division;
    }

    /**
     * Returns the nurse associated with the medical record.
     * @return The nurse
     */
    public String getNurse(){
        return nurse;
    }

    /**
     * Returns the doctor associated with the medical record.
     * @return The doctor
     */
    public String getDoctor() {
        return doctor;
    }

    /**
     * Returns the id of the patient associated with the medical record.
     * @return The id
     */
    public String getPatientID(){ return patientID;}

    /**
     * Changes the disease of a patient.
     * @param newDisease
     */
    public void changeDisease(String newDisease){ disease = newDisease; }


}
