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

    public MedicalRecord getMedicalRecord(String patient, int index) {
        if (database.containsKey(patient)) {
            if (database.get(patient).size() > index) {
                return database.get(patient).get(index);
            } else {
                System.out.println("No such Medical Records found for " + patient);
            }
        } else {
            System.out.println(patient + " Not found in database");
        }
        return null;
    }

    public void remove(String patient, String index) {
        database.get(patient).remove(Integer.parseInt(index));
    }

    public boolean checkPatient(String patientID) {
        return database.containsKey(patientID);
    }

    public ArrayList<MedicalRecord> getPatientRecords(String patient) {
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
