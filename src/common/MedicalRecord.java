package common;

public class MedicalRecord {
    private String doctor;
    private String nurse;
    private int division;
    private String bloodType;
    private String patient;

    public MedicalRecord(String doctor, String nurse, int division, String bloodType, String patient){
        this.doctor = doctor;
        this.nurse = nurse;
        this.division = division;
        this.bloodType = bloodType;
        this.patient = patient;
    }


    public String toString(){
        return "Doctor: " + doctor + " Division: " + division + " Nurse: " + nurse + " Blood Type: " + bloodType;
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

    public String getPatient(){
        return patient;
    }

}
