package Common;

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
}
