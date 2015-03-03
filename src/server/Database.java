package server;

import common.MedicalRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *  A basic database for storage of medical records
 */
public class Database {
    private HashMap<String, ArrayList<MedicalRecord>> database;
    private ArrayList<MedicalRecord> recordList;
    Iterator<String> iter;

    /**
     *
     */
    public Database() {
        database = new HashMap<String, ArrayList<MedicalRecord>>();

    }

    /**
     * Adds a medical to the specified patient
     * @param patient
     * @param m
     */
    public void add(String patient, MedicalRecord m) {
        if (!database.containsKey(patient)) {
            database.put(patient, new ArrayList<MedicalRecord>());
        }
        database.get(patient).add(m);
    }

    /**
     * Retrieves a medical record from the specified patient and index
     * @param patient
     * @param index
     * @return MedicalRecord
     */
    public MedicalRecord getMedicalRecord(String patient, String index){
        int i = Integer.parseInt(index);
        if(database.containsKey(patient)){
            if(database.get(patient).size() > i){
                return database.get(patient).get(i);
            } else{
                System.out.println("No such Medical Records found for " + patient);
            }
        } else {
            System.out.println(patient + " Not found in database");
        }
        return null;
    }

    /**
     * Removes a medical record from the specified patient and index
     * @param patient
     * @param index
     */
    public void remove(String patient, String index) {
        database.get(patient).remove(Integer.parseInt(index));
    }

    /**
     * Checks if a patient exists in the database or not.
     * @param patientID
     * @return boolean
     */
    public boolean checkPatient(String patientID){
        return database.containsKey(patientID);
    }

    /**
     * Returns a list of medical record for the specified patient.
     * @param patient
     * @return ArrayList<MedicalRecord>
     */
    public ArrayList<MedicalRecord> getPatientRecords(String patient) {
        if (database.containsKey(patient)) {
            return database.get(patient);
        } else {
            System.out.println("No such patient found");
            return null;
        }
    }

}
