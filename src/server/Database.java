package server;
import common.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    private HashMap<String, ArrayList<MedicalRecord>> PatientDB;
    private HashMap<Integer, ArrayList<MedicalRecord>> DivisionDB;

    public Database(){
        PatientDB = new HashMap<String, ArrayList<MedicalRecord>>();
        DivisionDB = new HashMap<Integer, ArrayList<MedicalRecord>>();
    }


}
