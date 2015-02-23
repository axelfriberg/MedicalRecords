package server;

import common.MedicalRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Database {
    private HashMap<String, ArrayList<MedicalRecord>> database;
    private ArrayList<MedicalRecord> recordList;
    Iterator<String> iter;

    public Database() {
        database = new HashMap<String, ArrayList<MedicalRecord>>();

    }

    public void add(String patient, MedicalRecord m) {
        if (!database.containsKey(patient)) {
            database.put(patient, new ArrayList<MedicalRecord>());
        }
        database.get(patient).add(m);



    }
    public MedicalRecord getMedicalRevord(int id){
        recordList = new ArrayList<MedicalRecord>();
        iter = database.keySet().iterator();
        while(iter.hasNext()){
            for(MedicalRecord m : database.get(iter.next())){
                if(m.getId() == id){
                    return m;
                }
            }
        }
        System.out.println("No such Medical Record found");
        return null;
    }

    public void remove(String patient, MedicalRecord medicalRecord) {
        boolean removedRecord = false;
        if (database.containsKey(patient)) {
            for (MedicalRecord m : database.get(patient)) {
                if (medicalRecord == m) {
                    removedRecord = true;
                    database.get(patient).remove(m);
                }
            }
            if (removedRecord) {
                System.out.println("Medical Record has successfully been removed");
            } else {
                System.out.println("No such Medical Record found");
            }
        } else {
            System.out.println("No such patient found");
        }
    }

    public ArrayList<MedicalRecord> patientRecords(String patient) {
        if (database.containsKey(patient)) {
            return database.get(patient);
        } else {
            System.out.println("No such patient found");
            return null;
        }
    }

    public ArrayList<MedicalRecord> divisionRecords(int div) {
        recordList = new ArrayList<MedicalRecord>();
        iter = database.keySet().iterator();
        while (iter.hasNext()) {
            for (MedicalRecord m : database.get(iter.next())) {
                if (m.getDivision() == div) {
                    recordList.add(m);
                }
            }
        }
        if (recordList.size() > 0) {
            return recordList;
        } else {
            System.out.println("No records found for this division");
            return null;
        }
    }

    public ArrayList<MedicalRecord> nurseRecords(String nurse) {
        recordList = new ArrayList<MedicalRecord>();
        iter = database.keySet().iterator();
        while (iter.hasNext()) {
            for (MedicalRecord m : database.get(iter.next())) {
                if (m.getNurse().equals(nurse)) {
                    recordList.add(m);
                }
            }
        }
        if (recordList.size() > 0) {
            return recordList;
        } else {
            System.out.println("No records found for this nurse");
            return null;
        }
    }

    public ArrayList<MedicalRecord> doctorRecords(String doctor) {
        recordList = new ArrayList<MedicalRecord>();
        iter = database.keySet().iterator();
        while (iter.hasNext()) {
            for (MedicalRecord m : database.get(iter.next())) {
                if (m.getDoctor().equals(doctor)) {
                    recordList.add(m);
                }
            }
        }
        if (recordList.size() > 0) {
            return recordList;
        } else {
            System.out.println("No records found for this doctor");
            return null;
        }
    }

}
