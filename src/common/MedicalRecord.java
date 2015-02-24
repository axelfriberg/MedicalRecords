package common;

public class MedicalRecord {
    private String doctor;
    private String nurse;
    private int division;
    private String disease;
    private String patient;

    public MedicalRecord(String doctor, String nurse, int division, String disease, String patient){
        this.doctor = doctor;
        this.nurse = nurse;
        this.division = division;
        this.disease = disease;
        this.patient = patient;
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

    public String getPatient(){
        return patient;
    }
    public void changeDisease(String newDisease){ disease = newDisease;

    }
}
