package common;

public class MedicalRecord {
    private String doctor;
    private String nurse;
    private String division;
    private String bloodType;

    public MedicalRecord(String doctor, String nurse, String division, String bloodType){
        this.doctor = doctor;
        this.nurse = nurse;
        this.division = division;
        this.bloodType = bloodType;
    }

    public String toString(){
        return "Doctor: " + doctor + " Division: " + division + " Nurse:" + nurse + " Blood Type: " + bloodType;
    }
    public String getDivision(){
        return division;
    }
    public String getNurse(){
        return nurse;
    }

    public String getDoctor() {
        return doctor;
    }
}
