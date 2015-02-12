package server;
import common.MedicalRecord;
import java.util.HashMap;

public class Database {
    private HashMap<Integer, MedicalRecord> database;

    public Database(){
        database = new HashMap<Integer,MedicalRecord>();
    }

}
