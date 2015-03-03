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


    public String toString(){
        return "Doctor: " + doctor + " Division: " + division + " Nurse: " + nurse + " Disease: " + disease;
    }
    public int getDivision(){
        return division;
    }

    public String getNurse(){
        return nurse;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getPatientName(){ return patientName; }

    public String getPatientID(){ return patientID;}

    public void changeDisease(String newDisease){ disease = newDisease; }


}
