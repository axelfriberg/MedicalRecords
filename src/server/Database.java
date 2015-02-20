package server;
import common.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Database {
    private HashMap<String, ArrayList<MedicalRecord>> database;
    private ArrayList<MedicalRecord> recordList;
    Iterator<String> iter;

    public Database(){
        database = new HashMap<String, ArrayList<MedicalRecord>>();

    }
    public void add(String patient, MedicalRecord m){
        database.get(patient).add(m);

    }
    public void remove(String patient, MedicalRecord medicalRecord){
        for(MedicalRecord m: database.get(patient)){
            if(medicalRecord == m){
                database.get(patient).remove(m);
            }
        }
    }

    public ArrayList<MedicalRecord> patientRecords(String patient) {
        return database.get(patient);
    }
    public ArrayList<MedicalRecord> divisionRecords(String div){
        recordList = new ArrayList<MedicalRecord>();
        iter = database.keySet().iterator();
        while(iter.hasNext()){
            for(MedicalRecord m: database.get(iter.next())){
                if(m.getDivision().equals(div)){
                    recordList.add(m);
                }
            }
        }
        return recordList;
    }
    public ArrayList<MedicalRecord> nurseRecords(String nurse){
        recordList = new ArrayList<MedicalRecord>();
        iter = database.keySet().iterator();
        while(iter.hasNext()){
            for(MedicalRecord m: database.get(iter.next())){
                if(m.getNurse().equals(nurse)){
                    recordList.add(m);
                }
            }
        }
        return recordList;
    }
    public ArrayList<MedicalRecord> doctorRecords(String doctor){
        recordList = new ArrayList<MedicalRecord>();
        iter = database.keySet().iterator();
        while(iter.hasNext()){
            for(MedicalRecord m: database.get(iter.next())){
                if(m.getDoctor().equals(doctor)){
                    recordList.add(m);
                }
            }
        }
        return recordList;
    }

}
