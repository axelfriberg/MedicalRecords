package server;
import common.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    private HashMap<Integer, ArrayList<MedicalRecord>> database;

    public Database(){
        database = new HashMap<Integer,ArrayList<MedicalRecord>>();
    }

}
