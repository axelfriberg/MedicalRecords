package server;
import common.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Database {
    private HashMap<String, ArrayList<MedicalRecord>> dataBase;
    private ArrayList<MedicalRecord> recordList;
    Iterator<String> iter;

    public Database(){
        dataBase = new HashMap<String, ArrayList<MedicalRecord>>();

    }

    public ArrayList<MedicalRecord> patientRecords(String id){
        return dataBase.get(id);
    }
    public ArrayList<MedicalRecord> divisionRecords(String div){
        recordList = new ArrayList<MedicalRecord>();
        iter = dataBase.keySet().iterator();
        while(iter.hasNext()){
            for(MedicalRecord m: dataBase.get(iter.next())){
                if(m.getDivision().equals(div)){
                    recordList.add(m);
                }
            }
        }
        return recordList;
    }
    public ArrayList<MedicalRecord> nurseRecords(String nurse){
        recordList = new ArrayList<MedicalRecord>();
        iter = dataBase.keySet().iterator();
        while(iter.hasNext()){
            for(MedicalRecord m: dataBase.get(iter.next())){
                if(m.getNurse().equals(nurse)){
                    recordList.add(m);
                }
            }
        }
        return recordList;
    }
    public ArrayList<MedicalRecord> doctorRecords(String doctor){
        recordList = new ArrayList<MedicalRecord>();
        iter = dataBase.keySet().iterator();
        while(iter.hasNext()){
            for(MedicalRecord m:dataBase.get(iter.next())){
                if(m.getDoctor().equals(doctor)){
                    recordList.add(m);
                }
            }
        }
        return recordList;
    }

}
