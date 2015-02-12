package common;

public class MedicalRecord {
    String nurse;
    String doctor;
    String division;
    String bloodType;

    public MedicalRecord(String nurse, String doctor, String division, String bloodType){
        this.nurse = nurse;
        this.doctor = doctor;
        this.division = division;
        this.bloodType = bloodType;
    }
}
